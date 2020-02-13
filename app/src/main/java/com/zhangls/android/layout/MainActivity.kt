package com.zhangls.android.layout

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.zhangls.android.layout.extension.toColorInt
import qiu.niorgai.StatusBarCompat


/**
 * @author zhangls
 */
class MainActivity : AppCompatActivity() {

  private lateinit var mainActivityView: MainActivityView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    mainActivityView = MainActivityView(this)
    setContentView(mainActivityView)
    setSupportActionBar(mainActivityView.toolbar)
    StatusBarCompat.changeToLightStatusBar(this)
    StatusBarCompat.setStatusBarColor(this, toColorInt(R.color.colorPrimary))

    mainActivityView.fab.setOnClickListener { view ->
      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Action", null).show()
    }
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menu.add(0, R.id.action_settings, 100, R.string.action_settings).apply {
      setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER)
    }

    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.action_settings -> {
        Toast.makeText(this, "你点击了设置", Toast.LENGTH_SHORT).show()
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }
}
