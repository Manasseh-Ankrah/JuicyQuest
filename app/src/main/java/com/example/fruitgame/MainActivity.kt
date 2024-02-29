package com.example.fruitgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.fruitgame.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    //Initializing bindings
    private lateinit var binding: ActivityMainBinding
    private var isToggled: Boolean = false
    private var isGuessSelected: Boolean = false
    private var isRandomSelected: Boolean = false

    private var selectedGuessImage = R.drawable.ic_pic_foreground
    private var selectedRandomImage = R.drawable.ic_pic_foreground


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //Inflate the activity binding
        binding = ActivityMainBinding.inflate(layoutInflater )
        val view = binding.root
        setContentView(view)
        // Log.w("Clicked","Clicked Grapes")


        val fruitList = listOf(R.drawable.apple,R.drawable.grapes,R.drawable.orange)

        binding.switchStart.setOnCheckedChangeListener {_, isChecked ->
            handleSwitchText(isChecked)
            handleStart(isChecked)
            handleReset(isChecked)
        }



            binding.btnGrapes.setOnClickListener {
                handleClickedGrapes(it)
            }

            binding.btnApple.setOnClickListener {
                handleClickedApple(it)
            }

            binding.btnRandom.setOnClickListener {
                handleClickedRandom(fruitList, it)
            }




    }

    private fun handleClickedRandom(
        fruitList: List<Int>,
        it: View
    ) {
        val shuffle = fruitList.shuffled().first()
        if (isToggled) {
            if (!isGuessSelected) {
                Snackbar.make(it, "Choose guess image to proceed", Snackbar.LENGTH_LONG).show()
            } else {
                binding.imageRandom.setImageResource(shuffle)
                selectedRandomImage = shuffle
                isRandomSelected = true
                // Decide win or lose
                handleGameOutcome(it)
            }
        } else {
            Snackbar.make(it, "Swith to start game", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun handleClickedGrapes(it: View) {
        if (isRandomSelected) {
            binding.imageRandom.setImageResource(R.drawable.ic_pic_foreground)
        }
        if (isToggled) {
            binding.imageGuess.setImageResource(R.drawable.grapes)
            isGuessSelected = true
            selectedGuessImage = R.drawable.grapes

        } else {
            Snackbar.make(it, "Swith to start game", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun handleClickedApple(it: View) {
        if (isRandomSelected) {
            binding.imageRandom.setImageResource(R.drawable.ic_pic_foreground)
        }
        if (isToggled) {
            binding.imageGuess.setImageResource(R.drawable.apple)
            isGuessSelected = true
            selectedGuessImage = R.drawable.apple

        } else {
            Snackbar.make(it, "Swith to start game", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun handleGameOutcome(it: View) {
        if (selectedGuessImage === selectedRandomImage) {
            Snackbar.make(it, "Congratulations, you won!", Snackbar.LENGTH_LONG).show()
        } else {
            Snackbar.make(it, "Oopps, you lost!", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun handleSwitchText(isChecked: Boolean) {
        if (isChecked) {
            binding.switchStart.text = "Stop Game"
        } else {
            binding.switchStart.text = "Start Game"
        }
    }

    private fun handleReset(isChecked: Boolean) {
        if (!isChecked) {
//            Log.w("Switch isChecked", "value $isChecked")
            binding.imageGuess.setImageResource(R.drawable.ic_pic_foreground)
            binding.imageRandom.setImageResource(R.drawable.ic_pic_foreground)
            isGuessSelected = false
        }
    }

    private fun handleStart(isChecked:Boolean) {
        Log.w("Switch Toggled","value $isChecked")
        isToggled= isChecked
    }
}