package com.raju.kotlin.bus.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.raju.kotlin.bus.Listen
import java.lang.reflect.InvocationTargetException

/**
 * Created by Rajashekhar Vanahalli on 10 April, 2023
 */
open class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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