package com.raju.kotlin.bus.ui

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.raju.kotlin.bus.KotlinBus
import com.raju.kotlin.bus.Listen
import com.raju.kotlin.bus.databinding.ActivityMainBinding
import com.raju.kotlin.bus.toast
import com.raju.kotlin.bus.ui.base.BaseActivity
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnPublish.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
            finish()
        }
    }

    @Listen
    fun onEventTriggered() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                KotlinBus.subscribe<String> {
                    toast(it)
                }
            }
        }
    }
}