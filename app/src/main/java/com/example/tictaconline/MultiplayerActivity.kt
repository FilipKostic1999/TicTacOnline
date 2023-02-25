package com.example.tictaconline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.tictaconline.databinding.ActivityMultiplayerBinding

class MultiplayerActivity : AppCompatActivity() {

    enum class Turn
    {
        NOUGHT,
        CROSS
    }

    private var firstTurn = Turn.CROSS
    private var currentTurn = Turn.NOUGHT

    private var boardList = mutableListOf<Button>()

    private lateinit var binding : ActivityMultiplayerBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMultiplayerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBoard()
    }

    private fun initBoard() {

        boardList.add(binding.a1)
        boardList.add(binding.a2)
        boardList.add(binding.a3)
        boardList.add(binding.b1)
        boardList.add(binding.b2)
        boardList.add(binding.b3)
        boardList.add(binding.c1)
        boardList.add(binding.c2)
        boardList.add(binding.c3)
    }

    fun boardTaped(view: View) {

        if (view !is Button)
            return
        addToBoard(view)
    }
    private fun addToBoard(button: Button){

        if(button.text != "")
            return

        if (currentTurn == Turn.NOUGHT){
            button.text = NOUGHT
            currentTurn = Turn.CROSS
        }
        else if (currentTurn == Turn.CROSS) {
            button.text = CROSS
            currentTurn = Turn.NOUGHT

        }

        setTurnLabel()
    }

    private fun setTurnLabel() {
        val turnText: String
        if (currentTurn == Turn.CROSS)
            turnText = "Turn $CROSS"
        else if (currentTurn == Turn.NOUGHT) {
            turnText = "Turn $NOUGHT"

            binding.turnTV.text = turnText
        }
    }
        companion object{

        const val NOUGHT = "O"
        const val CROSS = "X"
    }

    }