# Testing Overview

Sources

[Testing Fundamentals](https://developer.android.com/training/testing/fundamentals)

## Discussion

1. What are the kinds of tests?
 * JVM - tests that run on your local machine (no Android APIs). Fast, not end-to-end
 * Instrumentation - tests that run on devices/emulators. Slower, higher fidelity
 
1. What are the available tools?
 * All
   * Accessibility Checker
 * Instrumentation Tests
   * Android Test Orchestrator
   * AndroidJUnitRunner
   * UIAutomator (multiple apps)
   * Espresso (single app)
 * JVM Tests
   * Robolectric
   * Simple unit tests
 
1. Where do they sit in the test pyramid?
^
| UIAutomator
| Espresso (minimal test doubles)
| Espresso (single fragment, test double dependencies)
| Robolectric
| Simple unit tests

1. What's the directory structure?
 * `androidTest` - instrumented
 * `test` - JVM
