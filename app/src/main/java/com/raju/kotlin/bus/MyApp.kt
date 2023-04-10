package com.raju.kotlin.bus

import android.app.Application
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by Rajashekhar Vanahalli on 10 April, 2023
 */
class MyApp: Application() {

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate() {
        super.onCreate()
        GlobalScope.launch {
            delay(5000L)
            KotlinBus.publish("Test data to publish")
        }
    }
}