# Gradle 

Sources
[Android Build Process](https://developer.android.com/studio/build)

The Android Build tool.

* Task runner
* Dependency Management
* It's what is actually used by the IDE

## Steps

1. What are the big picture steps in the Android build process
![Build Process Diagram](build_process.png "Android Build Process")

 * Orchestrated by gradle
 * Compilers convert manifest, source code, resources, AIDL (not so common--for interprocess data sharing) plus 3rd party libraries into DEX (Dalvik VM executable)
 * APK Packager then signs DEX files (with prod or debug key)
 * Output: *.apk, a package containing all of the above
 * Our gradle files instruct gradle which tasks to run and what inputs to include

1. Why ./gradlew and not gradle?
1. Why two build.gradle files?

 * Top level file defines the behavior of gradle itself
 * Top level file includes settings that are used cross-module
 * Module level files allow customization
 * app/build.gradle includes the android plugin, with all Android-specific options
    * compileSdkVersion, minSdkVersion, targetSdkVersion
    * versionCode/versionName
    * testInstrumentationRunner (we'll get to that later)
    * compileOptions -> sourceCompatibility/targetCompatibility
 * app/build.gradle dependencies (implementation/testImplementation/androidTestImplementation)

1. In command line, run `./gradlew tasks`
 * ./gradlew sourceSets
 * ./gradlew clean
 * ./gradlew assemble
 * ./gradlew lint
 * ./gradlew installDebug
 * Verification tasks -- coming soon!
 