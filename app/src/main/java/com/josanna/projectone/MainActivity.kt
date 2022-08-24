package com.josanna.projectone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.josanna.projectone.databinding.ActivityMainBinding
import com.josanna.projectone.ui.MainMenuFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentMainMenu = MainMenuFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragmentMainMenu)
            commit()
        }

    }

}