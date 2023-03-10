package com.example.tictaconline

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.tictaconline.databinding.ActivityMultiplayerBinding
import java.util.*

class MultiplayerActivity : AppCompatActivity() {

    enum class Turn {
        NOUGHT,
        CROSS
    }
    private var crossesScore = 0
    private var noughtsScore = 0

    private var firstTurn = Turn.CROSS
    private var currentTurn = Turn.NOUGHT

    lateinit var points_pl1: TextView
    lateinit var points_pl2: TextView


    var pointsPl1 = 0
    var pointsPl2 = 0


    private var boardList = mutableListOf<Button>()

    private lateinit var binding: ActivityMultiplayerBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





        binding = ActivityMultiplayerBinding.inflate(layoutInflater)
        setContentView(binding.root)




        points_pl1 = findViewById(R.id.points_Pl1)
        points_pl2 = findViewById(R.id.points_Pl2)

        val shared = getSharedPreferences("Score", MODE_PRIVATE)
        crossesScore = shared.getInt("Score", 0)
        noughtsScore = shared.getInt("Score2", 0)

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

   // val shared: SharedPreferences = getSharedPreferences("Score", MODE_PRIVATE)
    //crossesScore  = shared.getInt("Score", 0)
    //noughtsScore = shared.getInt("Score2", 0)


    fun boardTaped(view: View) {

        if (view !is Button)
            return
        addToBoard(view)
        
        if(checkForVictory(NOUGHT)){
            pointsPl1++
            noughtsScore++
            val shared = getSharedPreferences("Score", MODE_PRIVATE)
            val edit = shared.edit()

            edit.putInt("Score", noughtsScore)
            points_pl1.text = "pointsPl1: $pointsPl1"

            edit.commit()
            result("Noughts Win!")
        }

        if(checkForVictory(CROSS)){
            pointsPl2++
            crossesScore++
            val shared = getSharedPreferences("Score2", MODE_PRIVATE)
            val edit = shared.edit()

            edit.putInt("Score2", crossesScore)
            points_pl2.text = "pointsPl2: $pointsPl2"

            edit.commit()
            result("Crosses Win!")

        }

        if(fullBoard()) {

            result("Draw")
        }

    }

    private fun checkForVictory(s: String): Boolean {

        //horizontal victory
        if(match(binding.a1,s) && match(binding.a2,s) && match(binding.a3,s))
            return true
        if(match(binding.b1,s) && match(binding.b2,s) && match(binding.b3,s))
            return true
        if(match(binding.c1,s) && match(binding.c2,s) && match(binding.c3,s))
            return true

        //vertical victory
        if(match(binding.a1,s) && match(binding.b1,s) && match(binding.c1,s))
            return true
        if(match(binding.a2,s) && match(binding.b2,s) && match(binding.c2,s))
            return true
        if(match(binding.a3,s) && match(binding.b3,s) && match(binding.c3,s))
            return true

        //diagonal victory
        if(match(binding.a1,s) && match(binding.b2,s) && match(binding.c3,s))
            return true
        if(match(binding.a3,s) && match(binding.b2,s) && match(binding.c1,s))
            return true


        return false


    }

    private fun match(button: Button, symbol : String): Boolean = button.text == symbol

    private fun result(title: String) {

        val message = "\nNoughts $noughtsScore\n\nCrosses $crossesScore"
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Reset") { _, _ ->
                resetBoard()
            }
            .setCancelable(false)
            .show()
    }

    private fun resetBoard(){

        for(button in boardList)
        {
            button.text = ""
        }

        if(firstTurn == Turn.NOUGHT)
            firstTurn = Turn.CROSS
        else if(firstTurn == Turn.CROSS)
            firstTurn = Turn.NOUGHT

        currentTurn = firstTurn
        setTurnLabel()


    }

    private fun fullBoard(): Boolean {
        for(button in boardList)

        {

            if (button.text == "")
                return false
        
        }
            return true
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
        var turnText: String
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

