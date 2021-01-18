# Handling UI Interactions And Intents

Sources:
[Intents](https://developer.android.com/reference/android/content/Intent)
[Button Interactions](https://developer.android.com/codelabs/android-training-layout-editor-part-a?hl=en#3)

## Introduction

How does our app connect its behavior to the user's interaction with the device? And similarly, how is information transmitted between apps and between activities? 

## Handling UI Interactions

1. In `activity_main.xml`, add a button from the palette to the layout.
 * constrain it to halfway between our text and the bottom of the screen
 * assign it text from `strings.xml`
 * play with appearance settings. Set some inset values in the attributes editor 
2. Add a click handler
 * In `activity_main.xml`, add a clickHandler (`android:onClick`) `logClick` and have Android Studio autogenerate a function in `MainActivity.kt`
 * Remove the entry in the layout file and the `logClick` function
 * Use `findViewById` and `setOnClickListener` to set a click listener entirely in code
 