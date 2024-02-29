package com.example.fruitgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fruitgame.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    //Initializing bindings
    private lateinit var binding: ActivityMainBinding
    private var isToggled: Boolean = false

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
            handleReset(isChecked)
        }





            binding.btnGrapes.setOnClickListener {
                if (isToggled) {
                Log.w("Switch Toggled","value $isToggled")
                   binding.imageGuess.setImageResource(R.drawable.grapes)
               } else {
                   Snackbar.make(it,"Swith to start game",Snackbar.LENGTH_LONG).show()
            }
            }

            binding.btnApple.setOnClickListener {
                if (isToggled) {
                    Log.w("Switch Toggled","value $isToggled")
                binding.imageGuess.setImageResource(R.drawable.apple)
                } else {
                    Snackbar.make(it,"Swith to start game",Snackbar.LENGTH_LONG).show()
                }
            }

            binding.btnRandom.setOnClickListener {
                val shuffle = fruitList.shuffled().first()
                if (isToggled) {
                    Log.w("Switch Toggled","value $isToggled")
                binding.imageRandom.setImageResource(shuffle)
                } else {
                    Snackbar.make(it,"Swith to start game",Snackbar.LENGTH_LONG).show()
                }

            }




    }

    private fun handleReset(isChecked: Boolean) {
        if (!isChecked) {
            Log.w("Switch isChecked", "value $isChecked")
            binding.imageGuess.setImageResource(R.drawable.ic_pic_foreground)
            binding.imageRandom.setImageResource(R.drawable.ic_pic_foreground)
        }
    }

    private fun handleStart(isChecked:Boolean) {
        Log.w("Switch Toggled","value $isChecked")
        isToggled= isChecked
    }
}