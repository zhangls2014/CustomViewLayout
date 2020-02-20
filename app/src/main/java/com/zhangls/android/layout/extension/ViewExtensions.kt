@file:Suppress("unused")

package com.zhangls.android.layout.extension

import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout


val View.wrapContent: Int
  get() = ViewGroup.LayoutParams.WRAP_CONTENT

val View.matchParent: Int
  get() = ViewGroup.LayoutParams.MATCH_PARENT

val ViewGroup.wrapContent: Int
  get() = ViewGroup.LayoutParams.WRAP_CONTENT

val ViewGroup.matchParent: Int
  get() = ViewGroup.LayoutParams.MATCH_PARENT

val ConstraintLayout.matchConstraint: Int
  get() = ConstraintLayout.LayoutParams.MATCH_CONSTRAINT

val ConstraintLayout.LayoutParams.parentId: Int
  get() = ConstraintLayout.LayoutParams.PARENT_ID

/**
 * 配置 LayoutParams 的扩展内联函数
 */
fun ViewGroup.coordinatorLayoutParams(
  width: Int,
  height: Int,
  params: (CoordinatorLayout.LayoutParams.() -> Unit)? = null
): CoordinatorLayout.LayoutParams {
  val layoutParams = CoordinatorLayout.LayoutParams(width, height)
  params?.let { it(layoutParams) }
  return layoutParams
}

fun ViewGroup.constrainLayoutParams(
  width: Int,
  height: Int,
  params: (ConstraintLayout.LayoutParams.() -> Unit)? = null
): ConstraintLayout.LayoutParams {
  val layoutParams = ConstraintLayout.LayoutParams(width, height)
  params?.let { it(layoutParams) }
  return layoutParams
}