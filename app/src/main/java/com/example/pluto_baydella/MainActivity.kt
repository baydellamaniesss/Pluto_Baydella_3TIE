package com.example.pluto_baydella

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pluto_baydella.databinding.ActivityMainBinding
import com.example.pluto_baydella.Home.pertemuan_4.FourthActivity
import com.example.pluto_baydella.Home.pertemuan_5.FifthActivity
import com.example.pluto_baydella.Home.pertemuan_6.SixthActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("onCreate", "MainActivity dibuat pertama kali")
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
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

        val sharedPref = getSharedPreferences(
            "user_pref",
            MODE_PRIVATE
        )

        // TOMBOL MENUJU FOURTH ACTIVITY
        binding.btnToFourth.setOnClickListener {

            val intent = Intent(
                this,
                FourthActivity::class.java
            )

            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 19)

            startActivity(intent)
        }

        // TOMBOL MENUJU FIFTH ACTIVITY
        binding.btnToFifth.setOnClickListener {

            val intent = Intent(
                this,
                FifthActivity::class.java
            )

            startActivity(intent)
        }

        binding.btnToSixth.setOnClickListener {

            val intent = Intent(
                this,
                SixthActivity::class.java
            )

            startActivity(intent)
        }
        // TOMBOL LOGOUT
        binding.btnLogout.setOnClickListener {

            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->

                    sharedPref.edit().clear().apply()

                    val intent = Intent(
                        this,
                        AuthActivity::class.java
                    )

                    startActivity(intent)
                    finish()

                    dialog.dismiss()

                    Log.e("Info Dialog", "Anda memilih Ya!")
                }
                .setNegativeButton("Batal") { dialog, _ ->

                    dialog.dismiss()

                    Log.e("Info Dialog", "Anda memilih Tidak!")
                }
                .show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "MainActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "MainActivity dihapus dari stack")
    }
}
