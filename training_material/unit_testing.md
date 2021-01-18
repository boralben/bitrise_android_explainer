# Unit Testing

Sources

[Local Unit Tests](https://developer.android.com/training/testing/unit-testing/local-unit-tests)
[Testing Basics 5.1](https://developer.android.com/codelabs/advanced-android-kotlin-training-testing-basics)

1. Check out `ExampleUnitTest`
 * Run with play button
 * Modify to make it fail, replay
 * Run with `./gradlew app:testDebugUnitTest`
 * Fix the test
 * Add a failing test `subtraction_isCorrect`
 * Run `./gradlew test --tests com.benboral.saucelabstraining.ExampleUnitTest.addition_isCorrect`

1. Testing our ViewModel
 * Write `ScreenInfoViewModelTests`
 
 ```kotlin
 class ScreenInfoViewModelTests {
     @Test
     fun incrementCount_updatesCountByOne() {
         val viewModel = ScreenInfoViewModel()
         assertEquals(0, viewModel.clickCount)
         viewModel.incrementCount()
         assertEquals(1, viewModel.clickCount)
     }
 }
```

 * Run the test: `RuntimeException: Method getMainLooper in android.os.Looper not mocked`
 * Explain the looper and lack of mocking
 * Robolectric is our solution (shadow implementation)
 * Add to build.gradle:
 ```groovy
    testImplementation 'androidx.test.ext:junit-ktx:1.1.2'
    testImplementation 'androidx.test:core-ktx:1.3.0'
    testImplementation 'org.robolectric:robolectric:4.4'
```
 * Add annotation to test class `@RunWith(AndroidJUnit4::class)`
 * Rerun the test. It fails! But for a new reason. Type mismatch. 
   * We could just unwrap the value with `viewModel.clickCount.value` 
   * `LiveData` implements the observer pattern, so let's use that as an opportunity to explore a different way of accessing the value:
 ```kotlin
    @Test
    fun incrementCount_updatesCountByOne_v2() {
        val viewModel = ScreenInfoViewModel()
        val expectedValues = mutableListOf(0, 1, 2)
        viewModel.clickCount.observeForever { count ->
            val expectedValue = expectedValues.removeAt(0)
            assertEquals(expectedValue, count)
        }
        viewModel.incrementCount()
        viewModel.incrementCount()
    }
```