package com.example.tictaconline

import com.google.firebase.firestore.DocumentId

data class grid(@DocumentId var DocumentId: String? = null, var a1 : Int = 0, var a2 : Int = 0,
var a3 : Int = 0, var b1 : Int = 0, var b2 : Int = 0, var b3 : Int = 0, var c1 : Int = 0,
var c2 : Int = 0, var c3 : Int = 0, var player1Turn : Boolean = false, var player2Turn : Boolean = false,
                var accepted : Boolean = false, var isSomebodyPresent : Boolean = false,
                var namePlayer1 : String = "", var namePlayer2 : String = "")

