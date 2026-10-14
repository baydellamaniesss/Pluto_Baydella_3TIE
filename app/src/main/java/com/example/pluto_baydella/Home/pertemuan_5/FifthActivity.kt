package com.example.pluto_baydella.Home.pertemuan_5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pluto_baydella.R
import com.example.pluto_baydella.databinding.ActivityFifthBinding

class FifthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )

            view.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        // Mengatur Toolbar
        setSupportActionBar(binding.toolbar)

        supportActionBar?.apply {
            title = "Activity Fifth"
            subtitle = "Ini adalah subtitle"

            // Menampilkan tombol kembali bawaan
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // Tombol menuju WebView
        binding.btnWebView.setOnClickListener {
            val intent = Intent(
                this,
                WebViewActivity::class.java
            )
            startActivity(intent)
        }
    }

    // Menangani klik menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            R.id.action_search -> {
                Toast.makeText(
                    this,
                    "Search Clicked",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.action_settings -> {
                Toast.makeText(
                    this,
                    "Settings Clicked",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    // Menampilkan menu pada Toolbar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}
