package com.example.pluto_baydella.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.pluto_baydella.AuthActivity
import com.example.pluto_baydella.Home.pertemuan_4.FourthActivity
import com.example.pluto_baydella.Home.pertemuan_5.FifthActivity
import com.example.pluto_baydella.Home.pertemuan_6.SixthActivity
import com.example.pluto_baydella.R
import com.example.pluto_baydella.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }

        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)

        // TOMBOL MENUJU FIFTH ACTIVITY
        binding.btnToFifth.setOnClickListener {

            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }

        binding.btnToSixth.setOnClickListener {

            val intent = Intent(
                requireContext(), SixthActivity::class.java)

            startActivity(intent)
        }
        // TOMBOL LOGOUT
        binding.btnLogout.setOnClickListener {

            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->

                    sharedPref.edit().clear().apply()

                    val intent = Intent(requireContext(), AuthActivity::class.java)

                    startActivity(intent)
                    requireActivity().finish()

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
}