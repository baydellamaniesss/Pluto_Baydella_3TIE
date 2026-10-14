
package com.example.pluto_baydella

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        val rootView = findViewById<android.view.View>(
            android.R.id.content
        )

        ViewCompat.setOnApplyWindowInsetsListener(rootView) { view, insets ->
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

        lifecycleScope.launch {

            // Tunggu selama 2 detik
            delay(2000)

            // Pindah ke MainActivity
            val intent = Intent(
                this@SplashScreenActivity,
                MainActivity::class.java
            )

            startActivity(intent)

            // Tutup SplashScreenActivity
            finish()
        }
    }
}
