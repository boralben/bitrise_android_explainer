# Handling UI Interactions 

Sources:
[Intents](https://developer.android.com/reference/android/content/Intent)
[Button Interactions](https://developer.android.com/codelabs/android-training-layout-editor-part-a?hl=en#3)
[Data Binding](https://developer.android.com/topic/libraries/data-binding)
[Binding LiveData](https://developer.android.com/topic/libraries/data-binding/architecture)

## Introduction

How does our app connect its behavior to the user's interaction with the device? 

## Handling UI Interactions

1. In `activity_main.xml`, add a button from the palette to the layout.
 * constrain it to halfway between our text and the bottom of the screen
 * assign it text from `strings.xml`
 * play with appearance settings. Set some inset values in the attributes editor 
2. Add a click handler
 * In `activity_main.xml`, add a clickHandler (`android:onClick`) `logClick` and have Android Studio autogenerate a function in `MainActivity.kt`
 * Remove the entry in the layout file and the `logClick` function
 * Use `findViewById` and `setOnClickListener` to set a click listener entirely in code
3. Data binding
 * Querying the layout with `findViewById` is cumbersome, but worse, can lead to null pointer exceptions if we query the view for an invalid id
 * Remove the code in `MainActivity.kt` to set the label text, the label entries in `strings.xml` and their usages in `activity_main.xml`
 * Add the following block to `app/build.gradle` in the `android` section: `buildFeatures { dataBinding true }` and sync
 * Create a `data class` called `ScreenInfo`
 * Wrap the `ConstraintLayout` in a `Layout` with a `data` child block of type `ScreenInfo` with attributes `labelText` and `buttonText`
 * In `activity_main.xml`, set the `android:text` values to "@{screenInfo.attrName}"
 * In `MainActivity.kt`, change `setContentView` to:
 ```kotlin
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        binding.screenInfo = ScreenInfo("Hello, World!", "Click Me!")
```
 * Run the app
 * Move the click listener code in `MainActivity.kt` to its own function called `logClick`
 * Add `binding.activity = this`
 * In activity_main.xml, add an activity data
 * In activity_main.xml, add `android:onClick="@{() -> activity.logClick() }"`
 
 (this only scratches the surface of data binding's capabilities)
 
 4. Update `ScreenInfo` to count clicks and update the label text to the number of clicks
  * Add a `incrementCount` function and a `clickCount` attribute
  * update the `activity_main.xml` to call `incrementCount` and associate the label text with `String.valueOf(screenInfo.clickCount)`
  * remote the activity from `<data>`
  * Run the app. (The label isn't updating)
 
 5. Click Counting continued
  * We'll need to use `LiveData` and `ViewModel`
  * Add to build.gradle: `implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0'`
  * Convert `ScreenInfo` to `ScreenInfoViewModel: ViewModel`
  * Convent `clickCount: Int` to `clickCount: LiveData<Int>`
  
 6. Let's reset our counter if the user exits our app
  * Make `ScreenInfoViewModel` lifecycle aware by implementing `LifeCycleObserver`
  * Add:
```kotlin
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun resetCounter() {
        clickCount.value = 0
    }
```
  * In `MainActivity` add `this.lifecycle.addObserver(viewModel)`