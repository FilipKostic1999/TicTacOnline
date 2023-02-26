package com.example.tictaconline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class onlineMultiplayer : AppCompatActivity() {


    lateinit var a1Column : ImageView
    lateinit var a2Column : ImageView
    lateinit var a3Column : ImageView

    lateinit var b1Column : ImageView
    lateinit var b2Column : ImageView
    lateinit var b3Column : ImageView

    lateinit var c1Column : ImageView
    lateinit var c2Column : ImageView
    lateinit var c3Column : ImageView


    lateinit var winnerTxt : TextView

    var player1Turn = true
    var player2Turn = false

    var a1 = 0
    var a2 = 0
    var a3 = 0

    var b1 = 0
    var b2 = 0
    var b3 = 0

    var c1 = 0
    var c2 = 0
    var c3 = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_online_multiplayer)



        a1Column = findViewById(R.id.a1Column)
        a2Column = findViewById(R.id.a2Column)
        a3Column = findViewById(R.id.a3Column)

        b1Column = findViewById(R.id.b1Column)
        b2Column = findViewById(R.id.b2Column)
        b3Column = findViewById(R.id.b3Column)

        c1Column = findViewById(R.id.c1Column)
        c2Column = findViewById(R.id.c2Column)
        c3Column = findViewById(R.id.c3Column)

        winnerTxt = findViewById(R.id.winnerTxt)



        a1Column.setOnClickListener {

            if (player1Turn && !player2Turn) {
                a1Column.setImageResource(R.drawable.cross)
                player1Turn = false
                player2Turn = true
                a1 = 1
            } else if (player2Turn && !player1Turn) {
                a1Column.setImageResource(R.drawable.donut)
                player1Turn = true
                player2Turn = false
                a1 = 2
            }

            a1Column.isEnabled = false
            checkWinner()
        }

        a2Column.setOnClickListener {

            if (player1Turn && !player2Turn) {
                a2Column.setImageResource(R.drawable.cross)
                player1Turn = false
                player2Turn = true
                a2 = 1
            } else if (player2Turn && !player1Turn) {
                a2Column.setImageResource(R.drawable.donut)
                player1Turn = true
                player2Turn = false
                a2 = 2
            }

            a2Column.isEnabled = false
            checkWinner()
        }

        a3Column.setOnClickListener {

            if (player1Turn && !player2Turn) {
                a3Column.setImageResource(R.drawable.cross)
                player1Turn = false
                player2Turn = true
                a3 = 1
            } else if (player2Turn && !player1Turn) {
                a3Column.setImageResource(R.drawable.donut)
                player1Turn = true
                player2Turn = false
                a3 = 2
            }

            a3Column.isEnabled = false
            checkWinner()
        }

        b1Column.setOnClickListener {

            if (player1Turn && !player2Turn) {
                b1Column.setImageResource(R.drawable.cross)
                player1Turn = false
                player2Turn = true
                b1 = 1
            } else if (player2Turn && !player1Turn) {
                b1Column.setImageResource(R.drawable.donut)
                player1Turn = true
                player2Turn = false
                b1 = 2
            }

            b1Column.isEnabled = false
            checkWinner()
        }


        b2Column.setOnClickListener {

            if (player1Turn && !player2Turn) {
                b2Column.setImageResource(R.drawable.cross)
                player1Turn = false
                player2Turn = true
                b2 = 1
            } else if (player2Turn && !player1Turn) {
                b2Column.setImageResource(R.drawable.donut)
                player1Turn = true
                player2Turn = false
                b2 = 2
            }

            b2Column.isEnabled = false
            checkWinner()
        }

        b3Column.setOnClickListener {

            if (player1Turn && !player2Turn) {
                b3Column.setImageResource(R.drawable.cross)
                player1Turn = false
                player2Turn = true
                b3 = 1
            } else if (player2Turn && !player1Turn) {
                b3Column.setImageResource(R.drawable.donut)
                player1Turn = true
                player2Turn = false
                b3 = 2
            }

            b3Column.isEnabled = false
            checkWinner()
        }

        c1Column.setOnClickListener {

            if (player1Turn && !player2Turn) {
                c1Column.setImageResource(R.drawable.cross)
                player1Turn = false
                player2Turn = true
                c1 = 1
            } else if (player2Turn && !player1Turn) {
                c1Column.setImageResource(R.drawable.donut)
                player1Turn = true
                player2Turn = false
                c1 = 2
            }

            c1Column.isEnabled = false
            checkWinner()
        }

        c2Column.setOnClickListener {

            if (player1Turn && !player2Turn) {
                c2Column.setImageResource(R.drawable.cross)
                player1Turn = false
                player2Turn = true
                c2 = 1
            } else if (player2Turn && !player1Turn) {
                c2Column.setImageResource(R.drawable.donut)
                player1Turn = true
                player2Turn = false
                c2 = 2
            }

            c2Column.isEnabled = false
            checkWinner()
        }

        c3Column.setOnClickListener {

            if (player1Turn && !player2Turn) {
                c3Column.setImageResource(R.drawable.cross)
                player1Turn = false
                player2Turn = true
                c3 = 1
            } else if (player2Turn && !player1Turn) {
                c3Column.setImageResource(R.drawable.donut)
                player1Turn = true
                player2Turn = false
                c3 = 2
            }

            c3Column.isEnabled = false
            checkWinner()
        }





    }



    fun checkWinner() {


        if (a1 == 1 && a2 == 1 && a3 == 1) {
            winnerTxt.text = "x wins"
        } else if (b1 == 1 && b2 == 1 && b3 == 1) {
            winnerTxt.text = "x wins"
        } else if (c1 == 1 && c2 == 1 && c3 == 1) {
            winnerTxt.text = "x wins"
        } else if (a1 == 1 && b2 == 1 && c3 == 1) {
            winnerTxt.text = "x wins"
        } else if (a3 == 1 && b2 == 1 && c1 == 1) {
            winnerTxt.text = "x wins"
        } else if (a1 == 1 && b1 == 1 && c1 == 1) {
            winnerTxt.text = "x wins"
        } else if (a2 == 1 && b2 == 1 && c2 == 1) {
            winnerTxt.text = "x wins"
        } else if (a3 == 1 && b3 == 1 && c3 == 1) {
            winnerTxt.text = "x wins"
        }


        if (a1 == 2 && a2 == 2 && a3 == 2) {
            winnerTxt.text = "o wins"
        } else if (b1 == 2 && b2 == 2 && b3 == 2) {
            winnerTxt.text = "o wins"
        } else if (c1 == 2 && c2 == 2 && c3 == 2) {
            winnerTxt.text = "o wins"
        } else if (a1 == 2 && b2 == 2 && c3 == 2) {
            winnerTxt.text = "o wins"
        } else if (a3 == 2 && b2 == 2 && c1 == 2) {
            winnerTxt.text = "o wins"
        } else if (a1 == 2 && b1 == 2 && c1 == 2) {
            winnerTxt.text = "o wins"
        } else if (a2 == 2 && b2 == 2 && c2 == 2) {
            winnerTxt.text = "o wins"
        } else if (a3 == 2 && b3 == 2 && c3 == 2) {
            winnerTxt.text = "o wins"
        }


        if (a1 > 0 && a2 > 0 && a3 > 0 && b1 > 0 && b2 > 0 && b3 > 0 && c1 > 0 && c2 > 0 && c3 > 0) {
            winnerTxt.text = "Draw"
        }





    }




}