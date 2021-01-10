# Activity Lifecycle

Sources: 

[Activity](https://developer.android.com/reference/android/app/Activity)

## Intro

An activity is "a single, focused thing that the user can do." Think of it as a the controller for the current screen presented to the user.

## Activity Lifecycle

![Lifecycle Diagram](activity_lifecycle.png "Android Activity Lifecycle")

## Experimentation

1. Override each of the listed lifecycle method and log activity state
1. Filter Logcat for "D/MainActivity" and observe the lifecycle methods getting invoked and lifecycle state changing.
1. Override `onSaveInstanceState()` and `onRestoreInstanceState()`

Uses for Lifecycle methods:

* start data requests
* pause media
* save data before destroy
* handling configuration changes (device rotation--common crash)

