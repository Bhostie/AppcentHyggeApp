package com.hyggeapp.barisgokmen.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.hyggeapp.barisgokmen.R
import com.hyggeapp.barisgokmen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ibCart.setOnClickListener {
            val navController = findNavController(R.id.fragment_container)
            navController.navigate(R.id.shoppingCartFragment)
        }
        binding.ibBack.setOnClickListener {
            val navController = findNavController(R.id.fragment_container)
            navController.navigateUp()
        }
    }


}