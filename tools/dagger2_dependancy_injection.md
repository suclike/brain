From the http://google.github.io/dagger/

The best classes in any application are the ones that do stuff: 
the `BarcodeDecoder`, the `KoopaPhysicsEngine`, and the `AudioStreamer`. 
These classes have dependencies; perhaps a `BarcodeCameraFinder`, `DefaultPhysicsEngine`, and an `HttpStreamer`.

To contrast, the worst classes in any application are the ones that take up space 
without doing much at all: 
the `BarcodeDecoderFactory`, the `CameraServiceLoader`, and the `MutableContextWrapper`. 
These classes are the clumsy duct tape that wires the interesting stuff together.

Dagger is a replacement for these `FactoryFactory` classes that implements the dependency injection design pattern without the burden of writing the boilerplate. It allows you to focus on the interesting classes. Declare dependencies, specify how to satisfy them, and ship your app.

By building on standard `javax.inject` annotations (JSR 330), each class is easy to test. You don't need a bunch of boilerplate just to swap the RpcCreditCardService out for a FakeCreditCardService.

== @Component ==

To get started in a dagger project, start with the @Component which glues everything together

```

@Component    // this is the interface between class that use injected type and class that produce them
( modules = { 
        // those are the class that knows how to @Provides types
        ApplicationModule.class, ConfigModule.class, ApiModule.class 
})
public interface ApplicationComponent { 

    // Those are the types that dagger knows how to produce and expose publicly
    Application application();
    EnvironmentConfig config();
    BackendService backendService();
    OpenBackendService openBackendService();
    ConversionService conversionService();
    
    // Those are the base class where the types above can be injected
    void injectIntoActivity(BaseActivity someActivity);
    void injectIntoFragment(BasicFragment someFragment);
    void injectIntoStethoPlugin(StethoSetup.NetworkPlugin plugin);
}
```

== Create the component and make it accessible ==

dagger provides for you a generated builder **DaggerApplicationComponent.builder()**
that you make accessible so that you can call the `injectIntoXXXX(Type type)` methods


```
public class SmfApplication extends Application {
    
    
    @Override
    public void onCreate() {
        super.onCreate();
        configureComponentAndInject()
        /*** All others Configure Methods go here ***/
        // configureLogging();
        // configureStrictMode();
                 
    }
    
    
    /*** DAGGER ***/    
    public void configureComponentAndInject() { 
        component = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    } 
    private static ApplicationComponent component;
    public static ApplicationComponent getComponent() {
        return component;
    }
```    

    
== Use your @Inject-ed fields ==
    
Say we want to use https://github.com/facebook/stetho to check quickly with `$ dumpapp network`
from the command-line wether our rest services are working as expected.
Since `BackendService` and friends are accessible from the ApplicationComponent,
we rely on dependancy injection to having them @Provides-ed to us.
    
```
public static class NetworkPlugin implements DumperPlugin {
    // declare the types you need
    @Inject protected BackendService backendService;
    @Inject protected OpenBackendService openBackendService;
    @Inject protected ConversionService conversionService;

    public NetworkPlugin() {
        // this will initialize the @Inject-ed fields 
        SmfApplication.applicationComponent().injectIntoStethoPlugin(this);
    }

    @Override
    public String getName() {
        return "network";   
    }


    @Override
    public void dump(DumperContext dumpContext) throws DumpException {
        PrintStream out = dumpContext.getStdout();
        // use backendService, openBackendService and  conversionService
        // out.print(openBackendService.helloWorld());
        out.flush();    
    }
}             
```    

== @Module : the class that knows how to @Provides types ==

This is the class that replaces the FactoryFactory classes.
This method for example provides the BackendService type.

```
@Module
public class ApiModule {

    @Provides
    BackendService providesBackendService(OkClient client, RequestInterceptor requestInterceptor) {
        BackendService service = null;
        try {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setRequestInterceptor(requestInterceptor)
                    .setEndpoint(BuildConfig.ENDPOINT)
                    .setClient(client)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();
            service = restAdapter.create(BackendService.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return service;
    }
```    

The class is annotated with @Module.
Each method that provides a type follow the convention

    @Provides  Type providesType(TypeNeeded typeNeeded) { .... }

This makes navigation easy. Want to know how `Gson` objects are provided?
Open symbol (Alt-Cmd-O) **providesGson()**

As you can see in the example, if you need other types to create you type,
you can just declare them as parameters and @Provides them with another function
      
```

    @Provides RequestInterceptor providesRequestInterceptor(final User user) {
        return new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Authorization", user.getAuthorisation());
                request.addHeader("Accept", "application/json");
            }
        };
    }
    
    // RequestInterceptor itself has a dependancy to....
    @Provides User providesUser() {
            return User.getCurrentUser();
    }


    @Provides  OkClient providesOkClient(OkHttpClient client) {
            return new OkClient(client);
    }
    // which in turn depends on
    @Provides OkHttpClient okHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.networkInterceptors().add(new StethoInterceptor());
        return okHttpClient;
    }
      
```       
      

== Links ==

http://google.github.io/dagger/
http://fernandocejas.com/2015/04/11/tasting-dagger-2-on-android/
https://guides.codepath.com/android/Dependency-Injection-with-Dagger-2

