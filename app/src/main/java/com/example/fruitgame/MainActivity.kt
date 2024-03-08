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

    private var selectedGuessImage = R.drawable.bg2
    private var selectedRandomImage = R.drawable.bg2
    private var wins = 0
    private var losses = 0



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
                Snackbar.make(it, "Choose guess image to proceed", Snackbar.LENGTH_SHORT).show()
            } else {
                binding.imageRandom.setImageResource(shuffle)
                selectedRandomImage = shuffle
                isRandomSelected = true
                // Decide win or lose
                handleGameOutcome(it)
            }
        } else {
            Snackbar.make(it, "Swith to start game", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun handleClickedGrapes(it: View) {
        if (isRandomSelected) {
            binding.imageRandom.setImageResource(R.drawable.bg2)
        }
        if (isToggled) {
            binding.imageGuess.setImageResource(R.drawable.grapes)
            isGuessSelected = true
            selectedGuessImage = R.drawable.grapes

        } else {
            Snackbar.make(it, "Swith to start game", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun handleClickedApple(it: View) {
        if (isRandomSelected) {
            binding.imageRandom.setImageResource(R.drawable.bg2)
        }
        if (isToggled) {
            binding.imageGuess.setImageResource(R.drawable.apple)
            isGuessSelected = true
            selectedGuessImage = R.drawable.apple

        } else {
            Snackbar.make(it, "Swith to start game", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun handleGameOutcome(it: View) {
        if (selectedGuessImage === selectedRandomImage) {
           var snack = Snackbar.make(it, "Congratulations, you won!", Snackbar.LENGTH_SHORT)
            snack.show()
            wins++
            binding.wonCount.text = wins.toString()
        } else {
            Snackbar.make(it, "Oopps, you lost!", Snackbar.LENGTH_SHORT).show()
            losses++
            binding.lostCount.text = losses.toString()
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
            binding.imageGuess.setImageResource(R.drawable.bg2)
            binding.imageRandom.setImageResource(R.drawable.bg2)
            isGuessSelected = false
            binding.wonCount.text = "0"
            binding.lostCount.text = "0"
            wins = 0
            losses = 0

        }
    }

    private fun handleStart(isChecked:Boolean) {
        Log.w("Switch Toggled","value $isChecked")
        isToggled= isChecked
    }
}