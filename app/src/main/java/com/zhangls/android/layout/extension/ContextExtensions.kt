package com.zhangls.android.layout.extension

import android.content.Context
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat


fun Context.colorInt(@ColorRes id: Int): Int = ContextCompat.getColor(this, id)