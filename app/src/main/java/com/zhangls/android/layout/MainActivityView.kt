package com.zhangls.android.layout

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.zhangls.android.layout.extension.*


/**
 * @author zhangls
 */
class MainActivityView : CoordinatorLayout {

  val toolbar = Toolbar(context).apply {
    val color = context.colorInt(R.color.colorPrimary)
    background = ColorDrawable(color)
    setTitle(R.string.app_name)
    setTitleTextColor(context.colorInt(android.R.color.white))
  }

  private val appBarLayout = AppBarLayout(context).apply {
    with(TypedValue()) {
      context.theme.resolveAttribute(android.R.attr.actionBarSize, this, true)
      val toolbarSize = context.resources.getDimensionPixelSize(resourceId)
      addView(toolbar, matchParent, toolbarSize)
    }

    layoutParams = coordinatorLayoutParams(matchParent, wrapContent)
  }

  val fab = FloatingActionButton(context).apply {
    setImageDrawable(context.getDrawable(android.R.drawable.ic_dialog_email))
    layoutParams = coordinatorLayoutParams(wrapContent, wrapContent) {
      gravity = Gravity.BOTTOM.or(Gravity.END)
      val margin = 16.dp
      setMargins(margin, margin, margin, margin)
    }
  }

  private val textView = TextView(context).apply {
    id = R.id.activity_main_hello
    text = resources.getString(R.string.activity_main_hello_world)
    setTextColor(context.colorInt(android.R.color.black))
    setBackgroundColor(context.colorInt(R.color.colorPrimary))

    layoutParams = constrainLayoutParams(wrapContent, wrapContent) {
      startToStart = parentId
      topToTop = parentId
      endToEnd = parentId
      bottomToBottom = parentId
    }
  }

  private val constraintLayout = ConstraintLayout(context).apply {
    id = View.generateViewId()

    layoutParams = coordinatorLayoutParams(matchParent, matchParent) {
      behavior = AppBarLayout.ScrollingViewBehavior()
    }

    addView(textView)
  }

  constructor(context: Context) : this(context, null)

  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    // appbar
    addView(appBarLayout)

    // content
    addView(constraintLayout)

    // fab
    addView(fab)
  }
}