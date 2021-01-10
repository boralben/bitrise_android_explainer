# Hello World App

A simple app to get us off the ground

Sources
[Codelab 1.1](https://developer.android.com/codelabs/android-training-hello-world?hl=en#3)

## Steps

1. Increase minSdkVersion in build.gradle and re-sync
1. File > Add New > Activity > Empty Activity
* Files created: 
 * MainActivity.kt (`onCreate()`)
 * activity_main.xml (code/design/split)
* Files modified
 * AndroidManifest.xml (activity definition)
1. Add a virtual device and click play
* Error: "Could not identify launch activity: Default Activity not found"
* Add this intent filter to the AndroidManifest.xml
```xml
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```
1. Try clicking play again. Our app launches!
1. Add "Hello World" to the ConstraintLayout
* Add an entry to `strings.xml`
* Drag the `TextView` into `activity_main.xml` and set
 * id
 * text
 * layout_width/layout_height
 * gravity
 * layout_constraints
1. Re-run the app
