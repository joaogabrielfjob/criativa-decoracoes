package com.criativadecoraes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.catalog_page.*

class CatalogActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.catalog_page)

    val items = arrayListOf<String>("a", "b")
    val themeAdapter = ThemeAdapter(items)

    recyclerViewThemes.hasFixedSize()
    recyclerViewThemes.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
    recyclerViewThemes.adapter = themeAdapter

    menuNavigation()
  }

  private fun menuNavigation() {
    bottom_navigation.selectedItemId = R.id.catalog_page

    bottom_navigation.setOnNavigationItemSelectedListener { item ->
      when(item.itemId) {
        R.id.home_page -> {
          openHomeActivity()
          true
        }

        R.id.catalog_page -> {
          openCatalogActivity()
          true
        }

        else -> false
      }
    }
  }

  private fun openHomeActivity()  {
    val intent = Intent(this, HomeActivity::class.java)

    startActivity(intent)
  }

  private fun openCatalogActivity()  {
    val intent = Intent(this, CatalogActivity::class.java)

    startActivity(intent)
  }
}