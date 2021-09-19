package com.smitcoderx.keepit.Ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.smitcoderx.keepit.Model.Notes
import com.smitcoderx.keepit.R
import com.smitcoderx.keepit.Ui.Fragments.Home.HomeFragmentDirections
import com.smitcoderx.keepit.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.apply {
            bottomNav.setupWithNavController(navController)
            bottomNav.background = null
            bottomNav.menu.getItem(1).isEnabled = false
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->

            binding.fab.setOnClickListener {
                if (destination.id == R.id.homeFragment) {
                    navController.navigate(HomeFragmentDirections.actionHomeFragmentToSingleFragment(
                        Notes()
                    ))
                } else {
                    navController.navigate(R.id.createFolderFragment)
                }
            }

            if (destination.id == R.id.singleFragment) {
                binding.apply {
                    bottomNav.visibility = View.GONE
                    bottomAppBar.visibility = View.GONE
                    fab.visibility = View.GONE
                }
            } else {
                binding.apply {
                    bottomNav.visibility = View.VISIBLE
                    bottomAppBar.visibility = View.VISIBLE
                    fab.visibility = View.VISIBLE
                }
            }
        }

    }
}