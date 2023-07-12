package com.hyggeapp.barisgokmen.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hyggeapp.barisgokmen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}