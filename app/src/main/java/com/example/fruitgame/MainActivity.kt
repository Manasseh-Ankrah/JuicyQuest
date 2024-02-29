package com.example.fruitgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fruitgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Initializing bindings
    private lateinit var binding: ActivityMainBinding
    private var toggleImage: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //Inflate the activity binding
        binding = ActivityMainBinding.inflate(layoutInflater )
        val view = binding.root
        setContentView(view)
        // Log.w("Clicked","Clicked Grapes")


        val fruitList = listOf(R.drawable.apple,R.drawable.grapes,R.drawable.orange)

        binding.switchStart.setOnCheckedChangeListener {_, isChecked ->
            handleStart(isChecked)
        }

        binding.btnGrapes.setOnClickListener {
            binding.imageGuess.setImageResource(R.drawable.grapes)
        }

        binding.btnApple.setOnClickListener {
            binding.imageGuess.setImageResource(R.drawable.apple)
        }

        binding.btnRandom.setOnClickListener {
            val shuffle = fruitList.shuffled().first()
            binding.imageRandom.setImageResource(shuffle)

        }

    }

    private fun handleStart(isChecked:Boolean) {
        Log.w("Switch Toggled","value $isChecked")
        toggleImage = isChecked
    }
}