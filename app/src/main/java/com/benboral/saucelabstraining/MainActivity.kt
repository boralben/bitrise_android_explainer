package com.benboral.saucelabstraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val labelText = resources.getString(R.string.text_hello_world)
        Log.d(this::class.simpleName, "Setting label to $labelText")
        findViewById<TextView>(R.id.main_TextView).text = labelText
    }
}