package com.example.tictaconline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class StatsActivity : AppCompatActivity() {


    lateinit var textViewP1 : TextView
    lateinit var textViewP2 : TextView


    lateinit var button_back : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)



        button_back = findViewById(R.id.button_back)




        button_back.setOnClickListener {

            val intent = Intent(this, MainActivity :: class.java)
            startActivity(intent)


        }


        textViewP1 = findViewById(R.id.Stats1)
        textViewP2 = findViewById(R.id.Stats2)


        val shared = getSharedPreferences("Score", MODE_PRIVATE)
        val Score = shared.getInt("Score", 0)

        Log.d("!!!", "score:  $Score" )


        val shared2 = getSharedPreferences("Score2", MODE_PRIVATE)
        val Score2 = shared2.getInt("Score2", 0)

        textViewP1.text = "Player1 wins: ${Score}"
        textViewP2.text = "Player2 wins: ${Score2}"

    }
}