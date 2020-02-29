package com.zhangls.android.layout

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.zhangls.android.layout.extension.*


/**
 * @author zhangls
 */
class MainView : CoordinatorLayout {

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

  private val fab = FloatingActionButton(context).apply {
    setImageDrawable(context.getDrawable(android.R.drawable.ic_dialog_email))
    layoutParams = coordinatorLayoutParams(wrapContent, wrapContent) {
      gravity = Gravity.BOTTOM.or(Gravity.END)
      val margin = 16.dp
      setMargins(margin, margin, margin, margin)
    }
    setOnClickListener { view ->
      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Action", null)
        .show()
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
      bottomToTop = R.id.guideline
    }
  }

  private val constraintLayout = ConstraintLayout(context).apply {
    layoutParams = coordinatorLayoutParams(matchParent, matchParent) {
      behavior = AppBarLayout.ScrollingViewBehavior()
    }

    addView(textView)

    with(Guideline(context)) {
      id = R.id.guideline
      layoutParams = constrainLayoutParams(wrapContent, wrapContent) {
        orientation = ConstraintLayout.LayoutParams.HORIZONTAL
        guidePercent = 0.5F
      }

      addView(this)
    }
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