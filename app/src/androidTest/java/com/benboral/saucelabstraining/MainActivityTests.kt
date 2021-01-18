package com.benboral.saucelabstraining


import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class MainActivityTests{

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun onLoad_ShowsLabel() {
        onView(withId(R.id.main_TextView)).check(matches(isDisplayed()))
    }

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

    @Test
    fun onExitApp_LabelResets() {
        onView(withId(R.id.button_first)).perform(click())
        activityScenarioRule.scenario.recreate()
        onView(withId(R.id.main_TextView)).check(matches(withText("0")))
    }
}