package com.raju.kotlin.bus

import android.content.Context
import android.widget.Toast

/**
 * Created by Rajashekhar Vanahalli on 10 April, 2023
 */
fun Context.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()