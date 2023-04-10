package com.raju.kotlin.bus.ui

import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.raju.kotlin.bus.KotlinBus
import com.raju.kotlin.bus.Listen
import com.raju.kotlin.bus.databinding.ActivitySecondBinding
import com.raju.kotlin.bus.ui.base.BaseActivity
import kotlinx.coroutines.launch

class SecondActivity : BaseActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    @Listen
    fun onEventTriggered() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                KotlinBus.subscribe<String> {
                    //toast(it)
                    binding.tvMessage.text = it
                }
            }
        }
    }
}