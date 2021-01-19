package com.benboral.saucelabstraining

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScreenInfoViewModelTests {

    @Test
    fun incrementCount_updatesCountByOne() {
        val viewModel = ScreenInfoViewModel()
        assertEquals(0, viewModel.clickCount.value)
        viewModel.incrementCount()
        assertEquals(1, viewModel.clickCount.value)
    }

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
}