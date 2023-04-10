package com.raju.kotlin.bus.ui

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.raju.kotlin.bus.KotlinBus
import com.raju.kotlin.bus.Listen
import com.raju.kotlin.bus.toast
import com.raju.kotlin.bus.ui.base.BaseFragment
import kotlinx.coroutines.launch

/**
 * Created by Rajashekhar Vanahalli on 10 April, 2023
 */
class MyFragment : BaseFragment() {

    @Listen
    fun onEventTriggered() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                KotlinBus.subscribe<String> {
                    activity?.toast(it)
                }
            }
        }
    }
}