package com.raju.kotlin.bus.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.raju.kotlin.bus.Listen
import java.lang.reflect.InvocationTargetException

/**
 * Created by Rajashekhar Vanahalli on 10 April, 2023
 */
open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeToKotlinBus()
    }

    private fun subscribeToKotlinBus() {
        for (declaredMethod in javaClass.declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Listen::class.java)) {
                try {
                    declaredMethod.invoke(this)
                } catch (e: IllegalAccessException) {
                    //Utils.logException(e)
                } catch (e: InvocationTargetException) {
                    //Utils.logException(e)
                }
            }
        }
    }
}