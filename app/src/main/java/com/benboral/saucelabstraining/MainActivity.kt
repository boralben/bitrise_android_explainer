package com.benboral.saucelabstraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val labelText = resources.getString(R.string.text_hello_world)
        findViewById<TextView>(R.id.main_TextView).text = labelText
    }
}