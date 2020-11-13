package com.criativadecoraes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.landing_page.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing_page)

        button_home.setOnClickListener { openHomeActivity() }
    }

    private fun openHomeActivity()  {
        val intent = Intent(this, HomeActivity::class.java)

        startActivity(intent)
    }
}