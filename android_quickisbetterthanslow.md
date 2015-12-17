
     Fast Is Better Than Slow   (Android Developer Edition)
     

Nothing extinguish the joy out of programming as quickly as a 2 minute compile-install-run cycle.

The tricks below are not new or anything, but if they can help at least one developer
in her work, the time spent writing them down would not have been wasted.


Give Android Studio more RAM
========

You have plenty of RAM and little time, so waste ram, not your time

Create a file called `studio.vmoptions` in a directory like `$HOME/Library/Preferences/AndroidStudio{VERSION}`

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

 
 
Set minSdkVersion to Lolipop for your debug builds
========

What if you could avoid while you are debugging the steps that are not required when your device runs lollipop or newer?
The Android Build system allows you to do that by defining two flavorDimensions :

- `:Adviqo:assembleInternLollipopAlpha`
- `:Adviqo:assembleStoreSupportDebug`

 
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
 
This can speed up your build from 40s to 10s (smile)

 
 
Gradle incremental builds and server mode
========


Make sure you have those options enabled in `$HOME/.gradle/gradle.properties`
 
 
```
org.gradle.daemon=true
org.gradle.parallel=true
```

 
Use an emulator
======

Using an emulator makes testing with different SDK version much simpler
 
It will spare you the time to install the .apk via usb, unpackage it and install it.

We used to have one good choice, we will hopefully have a second one soon

 
Genymotion
-----

```
# Install brew at http://brew.sh/ http://caskroom.io/
$ brew cask install virtualbox
$ open https://www.genymotion.com/#!/download
```
 
Then 
Install Genymotion
Create a device, for example Nexus 5
Start it


Google
-------

Google also released an emulation in Android Studio 2 beta

http://android-developers.blogspot.de/2015/12/android-studio-20-preview-android.html