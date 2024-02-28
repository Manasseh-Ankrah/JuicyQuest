package com.example.fruitgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fruitgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Initializing bindings
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflate the activity binding
        binding = ActivityMainBinding.inflate(layoutInflater )
        val view = binding.root
        setContentView(view)
    }
}