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

  private val appBarLayout = AppBarLayout(context).apply {
    context.setTheme(R.style.AppTheme_AppBarOverlay)
  }
  val toolbar = Toolbar(context).apply {
    popupTheme = R.style.AppTheme_PopupOverlay
    val color = context.colorInt(R.color.colorPrimary)
    background = ColorDrawable(color)
    setTitle(R.string.app_name)
    setTitleTextColor(context.colorInt(android.R.color.white))
  }
  val fab = FloatingActionButton(context).apply {
    setImageDrawable(context.getDrawable(android.R.drawable.ic_dialog_email))
  }
  private val constraintLayout = ConstraintLayout(context).apply { id = View.generateViewId() }
  private val textView = TextView(context).apply {
    id = R.id.activity_main_hello
    text = resources.getString(R.string.activity_main_hello_world)
    setTextColor(context.colorInt(android.R.color.black))
    setBackgroundColor(context.colorInt(R.color.colorPrimary))
  }

  init {
    // toolbar
    with(TypedValue()) {
      context.theme.resolveAttribute(android.R.attr.actionBarSize, this, true)
      val toolbarSize = context.resources.getDimensionPixelSize(resourceId)
      appBarLayout.addView(toolbar, matchParent, toolbarSize)
    }
    addView(appBarLayout, coordinatorLayoutParams(matchParent, wrapContent))

    // content
    constraintLayout.apply {
      addView(textView, constrainLayoutParams(wrapContent, wrapContent) {
        startToStart = parentId
        topToTop = parentId
        endToEnd = parentId
        bottomToBottom = parentId
      })
    }.let {
      addView(it, coordinatorLayoutParams(matchParent, matchParent) {
        behavior = AppBarLayout.ScrollingViewBehavior()
      })
    }

    // fab
    addView(fab, coordinatorLayoutParams(wrapContent, wrapContent) {
      gravity = Gravity.BOTTOM.or(Gravity.END)
      val margin = 16.dp
      setMargins(margin, margin, margin, margin)
    })
  }

  constructor(context: Context) : this(context, null)

  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
    context,
    attrs,
    defStyleAttr
  )
}