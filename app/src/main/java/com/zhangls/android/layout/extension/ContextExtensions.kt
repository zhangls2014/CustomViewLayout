package com.zhangls.android.layout.extension

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat


fun Context.toColorInt(@ColorRes id: Int): Int = ContextCompat.getColor(this, id)

fun Context.getDrawable(@DrawableRes id: Int): Drawable? = ContextCompat.getDrawable(this, id)