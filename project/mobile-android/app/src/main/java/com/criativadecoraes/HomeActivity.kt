package com.criativadecoraes

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.criativadecoraes.databinding.HomePageBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.home_page.*


class HomeActivity : AppCompatActivity(), OnMapReadyCallback {

  private lateinit var mMap: GoogleMap
  private lateinit var binding: HomePageBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = HomePageBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
    mapFragment.getMapAsync(this)

    button_whatsapp.setOnClickListener { openWhatsapp() }
    button_facebook.setOnClickListener { openFacebook() }
    button_instagram.setOnClickListener { openInstagram() }

    menuNavigation()
  }

  private fun openWhatsapp() {
    val number = "+555198204-2470"
    val url = "https://api.whatsapp.com/send?phone=$number"
    val intent = Intent(Intent.ACTION_VIEW)

    intent.data = Uri.parse(url)

    startActivity(intent)
  }

  private fun openFacebook() {
    val url = "https://www.facebook.com/familiacriativadecoracoes/"
    val intent = Intent(Intent.ACTION_VIEW)

    intent.data = Uri.parse(url)

    startActivity(intent)
  }

  private fun openInstagram() {
    val url = "https://www.instagram.com/familiacriativadecoracoes/"
    val intent = Intent(Intent.ACTION_VIEW)

    intent.data = Uri.parse(url)

    startActivity(intent)
  }

  override fun onMapReady(googleMap: GoogleMap) {
    val criativa = LatLng(-29.94483323361012, -51.05878948534485)

    mMap = googleMap
    mMap.addMarker(MarkerOptions().position(criativa).title("Criativa Decorações"))
    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(criativa, 15f))
  }

  private fun menuNavigation() {
    bottom_navigation.selectedItemId = R.id.home_page

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