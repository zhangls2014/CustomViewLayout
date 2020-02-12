package com.zhangls.android.layout

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
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
    val color = context.toColorInt(R.color.colorPrimary)
    background = ColorDrawable(color)
  }
  val fab = FloatingActionButton(context).apply {
    setImageDrawable(context.getDrawable(android.R.drawable.ic_dialog_email))
  }
  private val constraintLayout = ConstraintLayout(context).apply { id = View.generateViewId() }
  private val textView = TextView(context).apply {
    id = R.id.activity_main_hello
    text = resources.getString(R.string.activity_main_hello_world)
    setTextColor(context.toColorInt(android.R.color.black))
    setBackgroundColor(context.toColorInt(R.color.colorPrimary))
  }

  init {
    layoutParams = coordinatorLayoutParams(matchParent, matchParent)

    // toolbar
    appBarLayout.addView(toolbar, matchParent, wrapContent)
    addView(appBarLayout, coordinatorLayoutParams(matchParent, wrapContent))

    // content
    constraintLayout.apply {
      addView(textView, constrainLayoutParams(wrapContent, wrapContent) {
        startToStart = parentId
        topToTop = parentId
        endToEnd = parentId
        bottomToBottom = parentId
      })
      val colorBackground = context.toColorInt(android.R.color.white)
      background = ColorDrawable(colorBackground)
    }
//    ConstraintSet().apply {
//      connect(textView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START)
//      connect(textView.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP)
//      connect(textView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END)
//      connect(textView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
//      constrainWidth(textView.id, ConstraintSet.WRAP_CONTENT)
//      constrainHeight(textView.id, ConstraintSet.WRAP_CONTENT)
//      applyTo(constraintLayout)
//    }
    addView(constraintLayout, coordinatorLayoutParams(matchParent, matchParent) {
      behavior = AppBarLayout.ScrollingViewBehavior()
    })

    // fab
    addView(fab, coordinatorLayoutParams(wrapContent, wrapContent) {
      gravity = Gravity.BOTTOM.or(Gravity.END)
      val margin = 16.dpToPxInt
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