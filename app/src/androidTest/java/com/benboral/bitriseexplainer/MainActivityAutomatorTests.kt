package com.benboral.bitriseexplainer

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityAutomatorTests {

    val PACKAGE_NAME = "com.benboral.bitriseexplainer"
    val DEFAULT_TIMEOUT = 5000L

    private lateinit var device: UiDevice

    @Before
    fun startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        device = UiDevice.getInstance(getInstrumentation())

        // Start from the home screen
        device.pressHome()

        // Wait for launcher
        val launcherPackage: String = getLauncherPackageName()
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), DEFAULT_TIMEOUT)

        // Launch the blueprint app
        val context: Context = getApplicationContext()
        val intent = context.getPackageManager().getLaunchIntentForPackage(PACKAGE_NAME)
        intent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK) // Clear out any previous instances
        context.startActivity(intent)

        // Wait for the app to appear
        device.wait(Until.hasObject(By.pkg(PACKAGE_NAME).depth(0)), DEFAULT_TIMEOUT)
    }

    /**
     * Uses package manager to find the package name of the device launcher. Usually this package
     * is "com.android.launcher" but can be different at times. This is a generic solution which
     * works on all platforms.`
     */
    private fun getLauncherPackageName(): String {
        // Create launcher Intent
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)

        // Use PackageManager to get the launcher package name
        val pm = getApplicationContext<Context>().packageManager
        val resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)
        return resolveInfo!!.activityInfo.packageName
    }

    @Test
    fun onButtonClick_IncrementsLabel() {
        assertEquals("0", device.findObject(By.res("${PACKAGE_NAME}:id/main_TextView")).text)
        device.findObject(By.res("$PACKAGE_NAME:id/button_first")).click()
        assertEquals("1", device.findObject(By.res("${PACKAGE_NAME}:id/main_TextView")).text)
    }

    @Test
    fun onExitApp_LabelResets() {
        device.findObject(By.res("$PACKAGE_NAME:id/button_first")).click()
        device.pressHome()
        startMainActivityFromHomeScreen()
        assertEquals("0", device.findObject(By.res("${PACKAGE_NAME}:id/main_TextView")).text)
    }
}