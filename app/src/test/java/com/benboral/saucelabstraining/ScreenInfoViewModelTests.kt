package com.benboral.saucelabstraining


import org.junit.Assert.assertEquals
import org.junit.Test

class ScreenInfoViewModelTests {
    @Test
    fun incrementCount_updatesCountByOne() {
        val viewModel = ScreenInfoViewModel()
        assertEquals(0, viewModel.clickCount)
        viewModel.incrementCount()
        assertEquals(1, viewModel.clickCount)
    }
}