
     Fast Is Better Than Slow   (Android Developer Edition)
     

Nothing extinguish the joy out of programming as quickly as a 2 minute compile-install-run cycle.

The tricks below are not new or anything, but if they can help at least one developer
in her work, the time spent writing them down would not have been wasted.


Give Android Studio more RAM
========

You have plenty of RAM and little time, so waste ram, not your time

Create a file called `studio.vmoptions` in a directory like `$HOME/Library/Preferences/AndroidStudio{VERSION}` on OSX or `$HOME/.AndroidStudio{VERSION}` on Linux

Here is an example

``` 
# Runs JVM in Server mode with more optimizations and resources usage
# It may slow down the startup, but if you usually keep IDE running for few hours/days
# JVM may profile and optimize IDE better. Feel free to remove this flag.
-server
# Sets the initial size of the heap, default value is 256m
-Xms2G
# Max size of the memory allocation pool, default value is 1280m
-Xmx4G
# Sets the size of the allocated class metadata space that will trigger a GC the first time it is exceeded, defaul max value is 350m 
-XX:MetaspaceSize=1024m
```

Reference: https://sites.google.com/a/android.com/tools/tech-docs/configuration


Gradle incremental builds and server mode
========


Make sure you have those options enabled in `$HOME/.gradle/gradle.properties`
 
 
```
org.gradle.daemon=true
org.gradle.parallel=true
```

References: https://docs.gradle.org/current/userguide/build_environment.html

 
Set minSdkVersion to Lolipop for your debug builds
========

What if you could avoid while you are debugging the steps that are not required when your device runs lollipop or newer?
The Android Build system allows you to do that by defining two flavorDimensions :


 
Here is an example
 
``` 
android {

    flavorDimensions "flavors", "api"

    productFlavors {

        lollipop {
            flavorDimension "api"
            minSdkVersion 21
        }
        support {
            flavorDimension "api"
            minSdkVersion 15
        }

        intern {
            flavorDimension "flavors"
            applicationId "com.questico.fortunica.german"
        }
        store {
            flavorDimension "flavors"
            applicationId 'com.smartmobilefactory.adviqo'
        }
    }
}
```

You will then have as gradle tasks something like:

- `:app:assembleInternLollipopAlpha`
- `:app:assembleStoreSupportDebug`
 
This allowed me to decrease my build time from 40s to 10s (smile)

 
 


 
Use an emulator
======

Using an emulator makes testing with different SDK version much simpler
 
It will spare you the time to install the .apk via usb, unpackage it and install it.

I have myself a good experience with *Genymotion*


```
# Install brew at http://brew.sh/ http://caskroom.io/
$ brew cask install virtualbox
$ open https://www.genymotion.com/#!/download
```
 
Then 
Install Genymotion
Create a device, for example Nexus 5
Start it


Android Studio 2: Instant Run and Android Emulator
=====

Last but not least, those new important features are coming by Google itself, proving that things have definitely moved in the right direction in 2015.

In fact already available for testing,

I have not yet experience with them myselves, but here are the links to get you started, and if you have feedback to add,  in the comments, that will be very appreciated

- http://tools.android.com/tech-docs/instant-run
- http://android-developers.blogspot.de/2015/11/android-studio-20-preview.html
- http://android-developers.blogspot.com/2015/12/android-studio-20-preview-android.html
