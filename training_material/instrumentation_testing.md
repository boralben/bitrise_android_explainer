# Instrumentation Testing

Sources
[Instrumentation Tests](https://source.android.com/compatibility/tests/development/instrumentation)
[Espresso](https://developer.android.com/training/testing/espresso)
[ActivityScenario](https://developer.android.com/guide/components/activities/testing#recreate)
[UIAutomator](https://developer.android.com/training/testing/ui-automator)
[UIAutomater Sample Code](https://github.com/android/testing-samples/tree/main/ui/uiautomator/BasicSample)

## Introduction

1. What is an instrumentation test?
 * Runs in the device/emulator
 * Two processes run: the app process and the instrumentation process
 * test code runs in the instrumentation process
 * launched with `adb shell am instrument`

1. What frameworks exist to write instrumentation tests?
 * Espresso
    * for testing a single app
    * waits to run test commands until main thread is idle (more reliable)
    * provides a very simple API
    * as white box as you want
 * UIAutomator
    * black box
    * used to test behavior across multiple apps
    
1. What does Appium use?
 * Appium has drivers for both. 

## Steps

1. Run `ExampleInstrumentedTest`
 * Observe the adb command used in "Run": `adb shell am instrument -w -m    -e debug false -e class 'com.benboral.saucelabstraining.ExampleInstrumentedTest#useAppContext' com.benboral.saucelabstraining.test/androidx.test.runner.AndroidJUnitRunner`
 * Read the assertion and understand what's being accessed

Now let's write our own...
1. We need to disable animations to avoid flakiness. 

```shell script
adb shell settings put global window_animation_scale 0 && \
adb shell settings put global transition_animation_scale 0 && \
adb shell settings put global animator_duration_scale 0
```


1. Add the following dependencies to your `build.gradle`
```groovy
    androidTestImplementation 'org.hamcrest:hamcrest-library:1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
    androidTestImplementation 'androidx.test.uiautomator:uiautomator:2.2.0'
```

1. Create `MainActivityTests`
```kotlin
@RunWith(AndroidJUnit4::class)
class MainActivityTests{
    @Test
    fun onLoad_LabelShowsZero() {
        onView(withId(R.id.main_TextView)).check(matches(isDisplayed()))
    }
}
```

 * Review the components at play here:
     * onView (Takes a `Matcher`, returns a `ViewInteraction`)
     * check (Interaction that takes a `ViewAssertion`)
     * matches (Takes a matcher, returns a `ViewAssertion`)
     * One other component is `ViewAction` that we'll see later used with `ViewInteraction::perform()`  
     * Taken together, these are the core APIs of Espresso tests 
 * Run our test
     * Error: `No activities found. Did you forget to launch the activity by calling getActivity() or startActivitySync or similar?`

1. Let's launch the app by using a JUnit rule provided by Espresso

```kotlin
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)
```

    * Discussion of JUnit rules
    * What does ActivityScenario do

1. Write tests for our button

```kotlin
    @Test
    fun buttonNotClicked_LabelIsZero() {
        onView(withId(R.id.main_TextView)).check(matches(withText("0")))
        // note that matches simply takes a ViewMatcher, so we could also do the below
        onView(withText("0")).check(matches(isDisplayed()))
    }

    @Test
    fun onButtonClick_IncrementsLabel() {
        onView(withId(R.id.button_first)).perform(click())
        onView(withId(R.id.main_TextView)).check(matches(withText("1")))
    }
```

1. How do we test functionality related to the activity lifecycle? Using `ActivityScenario`:
```kotlin
    @Test
    fun onExitApp_LabelResets() {
        onView(withId(R.id.button_first)).perform(click())
        activityScenarioRule.scenario.recreate()
        onView(withId(R.id.main_TextView)).check(matches(withText("0")))
    }
```

1. Let's write a similar test using UIAutomator
 * Introduce the Layout Inspector
 * Show code in `MainActivityAutomatorTests.kt`
 