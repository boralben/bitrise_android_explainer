# Project Structure

[Source](https://developer.android.com/studio/intro)

## Android Studio

* Official IDE for Android dev
* Built on IntelliJ
* Built-In Android tooling (for ex. Android Virtual Device Manager)
* Gradle Integration

### Using Android Studio

1. Create an emulator in AVD
2. Run the app
3. As build is created, review bottom Panel
** Progress Indicator
** Terminal
** Git
** Run
** Profiler
** Build
** Logcat
4. Side Panels
** Left: Project structure (Android App view vs. Project View) (*Troubleshooting Tip* - Select Problems on dropdown)
** Right: Gradle tasks

## Directory Structure

* manifests/
** [AndroidManifest.xml](https://developer.android.com/guide/topics/manifest/manifest-intro) - Describes application identifiers, app components, OS permissions, device compatibility
* java/ - all source code including tests
* res/ - all non-code resources like layout files, image assets, strings definitions
