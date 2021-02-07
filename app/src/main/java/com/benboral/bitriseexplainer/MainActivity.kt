package com.benboral.bitriseexplainer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.benboral.bitriseexplainer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(this::class.simpleName, "onCreate  - ${lifecycle.currentState.name}")
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        val viewModel = ViewModelProvider(this).get(ScreenInfoViewModel::class.java)
        this.lifecycle.addObserver(viewModel)
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)
    }

    override fun onStart() {
        super.onStart()
        Log.d(this::class.simpleName, "onStart - ${lifecycle.currentState.name}")
    }

    override fun onResume() {
        super.onResume()
        Log.d(this::class.simpleName, "onResume - ${lifecycle.currentState.name}")
    }
    override fun onPause() {
        super.onPause()
        Log.d(this::class.simpleName, "onPause - ${lifecycle.currentState.name}")
    }
    override fun onStop() {
        super.onStop()
        Log.d(this::class.simpleName, "onStop - ${lifecycle.currentState.name}")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(this::class.simpleName, "onDestroy - ${lifecycle.currentState.name}")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(this::class.simpleName, "onSaveInstanceState - ${lifecycle.currentState.name}")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        savedInstanceState?.let { super.onRestoreInstanceState(it) }
        Log.d(this::class.simpleName, "onRestoreInstanceState - ${lifecycle.currentState.name}")
    }
}