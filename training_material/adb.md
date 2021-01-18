# ADB - Android Debug Bridge

Sources
[Android Debug Bridge(adb)](https://developer.android.com/studio/command-line/adb)

## ADB Components
 * client - runs on your machine and sends commands to the device
 * daemon - runs on the device. Receives commands and executes tasks
 * server - runs on your machine and connects with daemons on network or USB connected devices/emulators

## What can we do?
 * `adb shell`
  * unix commands
  * Activity Manager `am`
    * `am start`
    * `am instrument` (coming soon!)
    * `am profile start/stop`
  * Package Manager `pm`
    * `pm list packages`
    * `pm install/uninstall`
    * `pm clear`
    * `pm grant`
  * `screenrecord`
  
 (really just a small sample)
 
 ## Let's see real usage
 
 * Click the play button in Android Studio
 * Check the Build tab to see the gradle commands used
 * Check the Run tab to see the adb command invoked (`adb shell am start -n "com.benboral.saucelabstraining/com.benboral.saucelabstraining.MainActivity" -a android.intent.action.MAIN -c android.intent.category.LAUNCHER`)
 