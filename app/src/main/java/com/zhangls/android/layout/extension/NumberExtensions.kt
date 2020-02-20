package com.zhangls.android.layout.extension

import android.content.res.Resources
import android.util.TypedValue
import kotlin.math.roundToInt


/**
 * dp 转 px
 */
val Number.dpFloat: Float
  get() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    toFloat(),
    Resources.getSystem().displayMetrics
  )

/**
 * dp 转 px
 */
val Number.dp: Int
  get() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    toFloat(),
    Resources.getSystem().displayMetrics
  ).roundToInt()

/**
 * px 转 dp
 */
val Int.pxToDp: Float get() = this / Resources.getSystem().displayMetrics.density

/**
 * sp 转 px
 */
val Int.spToPx: Float
  get() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_SP,
    toFloat(),
    Resources.getSystem().displayMetrics
  )