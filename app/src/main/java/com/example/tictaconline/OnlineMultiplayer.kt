package com.example.tictaconline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.tictaconline.R.drawable.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class OnlineMultiplayer : AppCompatActivity() {


    lateinit var a1Column : ImageView
    lateinit var a2Column : ImageView
    lateinit var a3Column : ImageView

    lateinit var b1Column : ImageView
    lateinit var b2Column : ImageView
    lateinit var b3Column : ImageView

    lateinit var c1Column : ImageView
    lateinit var c2Column : ImageView
    lateinit var c3Column : ImageView

    lateinit var newMatchBtn : Button



    lateinit var winnerTxt : TextView
    lateinit var player1IsPresentTxt : TextView
    lateinit var player2IsPresentTxt : TextView



    lateinit var nameInDatabase: username
    lateinit var Grid1: grid

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


    var nameOfCurrentUser =  "ifie"
    var lobbyName = ""
    var isThisTheFirst = false
    var nameSet = false
    var matchCounter = 0.0
    lateinit var nameInDb : username






    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var database: FirebaseFirestore


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

        newMatchBtn = findViewById(R.id.newMatchBtn)



        winnerTxt = findViewById(R.id.winnerTxt)
        player1IsPresentTxt = findViewById(R.id.player1IsPresentTxt)
        player2IsPresentTxt = findViewById(R.id.player2IsPresentTxt)



        database = Firebase.firestore
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth = Firebase.auth

        val user = firebaseAuth.currentUser



        val sharedLobby = getSharedPreferences("SelectedLobby", AppCompatActivity.MODE_PRIVATE)
        var SelectedLobby = sharedLobby.getString("SelectedLobby", "")


        val sharedName = getSharedPreferences("Name", AppCompatActivity.MODE_PRIVATE)
        var Name = sharedName.getString("Name", "")




        if (SelectedLobby != null) {
            lobbyName = SelectedLobby
        }







        // Grid of current lobby


        database.collection("Users").document("All players")
            .collection("$SelectedLobby")

            .addSnapshotListener { snapshot, e ->
                if (snapshot != null) {
                    for (document in snapshot.documents) {

                        Grid1 = document.toObject()!!
                        Log.d("!!!", "${Grid1.a1}")


                        // decides who is player 1

                        if (!Grid1.isSomebodyPresent) {
                            Grid1.isSomebodyPresent = true
                            isThisTheFirst = true  // local variable
                            Grid1.player1Turn = true

                            if (Name != null) {
                                Grid1.namePlayer1 = Name
                            }
                            updateGrid()
                        } else {
                            if (Name != null && !nameSet) {
                                Grid1.namePlayer2 = Name
                                nameSet = true
                                updateGrid()
                            }
                        }


                        // Sets x and o for both players

                        if (Grid1.a1 == 1) {
                            a1Column.setImageResource(xline)
                        } else if (Grid1.a1 == 2) {
                            a1Column.setImageResource(oline)
                        } else if (Grid1.a1 == 0) {
                            a1Column.setImageResource(ticbc)
                        }


                        if (Grid1.a2 == 1) {
                            a2Column.setImageResource(xline)
                        } else if (Grid1.a2 == 2) {
                            a2Column.setImageResource(oline)
                        } else if (Grid1.a2 == 0) {
                            a2Column.setImageResource(oline)
                        }

                        if (Grid1.a3 == 1) {
                            a3Column.setImageResource(xline)
                        } else if (Grid1.a3 == 2) {
                            a3Column.setImageResource(oline)
                        } else if (Grid1.a3 == 0) {
                            a3Column.setImageResource(ticbc)
                        }

                        if (Grid1.b1 == 1) {
                            b1Column.setImageResource(xline)
                        } else if (Grid1.b1 == 2) {
                            b1Column.setImageResource(oline)
                        } else if (Grid1.b1 == 0) {
                            b1Column.setImageResource(ticbc)
                        }

                        if (Grid1.b2 == 1) {
                            b2Column.setImageResource(xline)
                        } else if (Grid1.b2 == 2) {
                            b2Column.setImageResource(oline)
                        } else if (Grid1.b2 == 0) {
                            b2Column.setImageResource(ticbc)
                        }

                        if (Grid1.b3 == 1) {
                            b3Column.setImageResource(xline)
                        } else if (Grid1.b3 == 2) {
                            b3Column.setImageResource(oline)
                        } else if (Grid1.b3 == 0) {
                            b3Column.setImageResource(ticbc)
                        }

                        if (Grid1.c1 == 1) {
                            c1Column.setImageResource(xline)
                        } else if (Grid1.c1 == 2) {
                            c1Column.setImageResource(oline)
                        } else if (Grid1.c1 == 0) {
                            c1Column.setImageResource(ticbc)
                        }

                        if (Grid1.c2 == 1) {
                            c2Column.setImageResource(xline)
                        } else if (Grid1.c2 == 2) {
                            c2Column.setImageResource(oline)
                        } else if (Grid1.c2 == 0) {
                            c2Column.setImageResource(ticbc)
                        }

                        if (Grid1.c3 == 1) {
                            c3Column.setImageResource(xline)
                        } else if (Grid1.c3 == 2) {
                            c3Column.setImageResource(oline)
                        } else if (Grid1.c3 == 0) {
                            c3Column.setImageResource(ticbc)
                        }



                        if (Grid1.player1Turn) {
                            winnerTxt.text = "It's ${Grid1.namePlayer1}'s turn"
                        } else if (Grid1.player2Turn) {
                            winnerTxt.text = "It's ${Grid1.namePlayer2}'s turn"
                        }



                        player1IsPresentTxt.text = "${Grid1.namePlayer1} is x"
                        player2IsPresentTxt.text = "${Grid1.namePlayer2} is o"

                        Log.d("!!!", "Player 1 turn is ${Grid1.player1Turn} and Player 2 turn is ${Grid1.player2Turn}, and isThisTheFirst is $isThisTheFirst")


                        if (Grid1.a1 > 0 && Grid1.a2 > 0 && Grid1.a3 > 0 && Grid1.b1 > 0 && Grid1.b2 > 0 && Grid1.b3 > 0 && Grid1.c1 > 0 && Grid1.c2 > 0 && Grid1.c3 > 0) {
                            winnerTxt.text = "Draw"
                            if (isThisTheFirst) {
                                Grid1.player1Turn = false
                                Grid1.player2Turn = false
                                newMatchBtn.isEnabled = true
                                updateGrid()
                            }
                        }


                        if (Grid1.a1 == 1 && Grid1.a2 == 1 && Grid1.a3 == 1) {
                            winnerTxt.text = "${Grid1.namePlayer1} wins"
                            if (isThisTheFirst) {
                                Grid1.player1Turn = false
                                Grid1.player2Turn = false
                                newMatchBtn.isEnabled = true
                                updateGrid()
                            }
                        } else if (Grid1.b1 == 1 && Grid1.b2 == 1 && Grid1.b3 == 1) {
                            winnerTxt.text = "${Grid1.namePlayer1} wins"
                            if (isThisTheFirst) {
                                Grid1.player1Turn = false
                                Grid1.player2Turn = false
                                newMatchBtn.isEnabled = true
                                updateGrid()
                            }
                        } else if (Grid1.c1 == 1 && Grid1.c2 == 1 && Grid1.c3 == 1) {
                            winnerTxt.text = "${Grid1.namePlayer1} wins"
                            if (isThisTheFirst) {
                                Grid1.player1Turn = false
                                Grid1.player2Turn = false
                                newMatchBtn.isEnabled = true
                                updateGrid()
                            }
                        } else if (Grid1.a1 == 1 && Grid1.b2 == 1 && Grid1.c3 == 1) {
                            winnerTxt.text = "${Grid1.namePlayer1} wins"
                            if (isThisTheFirst) {
                                Grid1.player1Turn = false
                                Grid1.player2Turn = false
                                newMatchBtn.isEnabled = true
                                updateGrid()
                            }
                        } else if (Grid1.a3 == 1 && Grid1.b2 == 1 && Grid1.c1 == 1) {
                            winnerTxt.text = "${Grid1.namePlayer1} wins"
                            if (isThisTheFirst) {
                                Grid1.player1Turn = false
                                Grid1.player2Turn = false
                                newMatchBtn.isEnabled = true
                                updateGrid()
                            }
                        } else if (Grid1.a1 == 1 && Grid1.b1 == 1 && Grid1.c1 == 1) {
                            winnerTxt.text = "${Grid1.namePlayer1} wins"
                            if (isThisTheFirst) {
                                Grid1.player1Turn = false
                                Grid1.player2Turn = false
                                newMatchBtn.isEnabled = true
                                updateGrid()
                            }
                        } else if (Grid1.a2 == 1 && Grid1.b2 == 1 && Grid1.c2 == 1) {
                            winnerTxt.text = "${Grid1.namePlayer1} wins"
                            if (isThisTheFirst) {
                                Grid1.player1Turn = false
                                Grid1.player2Turn = false
                                newMatchBtn.isEnabled = true
                                updateGrid()
                            }
                        } else if (Grid1.a3 == 1 && Grid1.b3 == 1 && Grid1.c3 == 1) {
                            winnerTxt.text = "${Grid1.namePlayer1} wins"
                            if (isThisTheFirst) {
                                Grid1.player1Turn = false
                                Grid1.player2Turn = false
                                newMatchBtn.isEnabled = true
                                updateGrid()
                            }
                        }


                        if (Grid1.a1 == 2 && Grid1.a2 == 2 && Grid1.a3 == 2) {
                            winnerTxt.text = "${Grid1.namePlayer2} wins"
                            if (isThisTheFirst) {
                                Grid1.player1Turn = false
                                Grid1.player2Turn = false
                                newMatchBtn.isEnabled = true
                                updateGrid()
                            }
                        } else if (Grid1.b1 == 2 && Grid1.b2 == 2 && Grid1.b3 == 2) {
                            winnerTxt.text = "${Grid1.namePlayer2} wins"
                            if (isThisTheFirst) {
                                Grid1.player1Turn = false
                                Grid1.player2Turn = false
                                newMatchBtn.isEnabled = true
                                updateGrid()
                            }
                        } else if (Grid1.c1 == 2 && Grid1.c2 == 2 && Grid1.c3 == 2) {
                            winnerTxt.text = "${Grid1.namePlayer2} wins"
                            if (isThisTheFirst) {
                                Grid1.player1Turn = false
                                Grid1.player2Turn = false
                                newMatchBtn.isEnabled = true
                                updateGrid()
                            }
                        } else if (Grid1.a1 == 2 && Grid1.b2 == 2 && Grid1.c3 == 2) {
                            winnerTxt.text = "${Grid1.namePlayer2} wins"
                            if (isThisTheFirst) {
                                Grid1.player1Turn = false
                                Grid1.player2Turn = false
                                newMatchBtn.isEnabled = true
                                updateGrid()
                            }
                        } else if (Grid1.a3 == 2 && Grid1.b2 == 2 && Grid1.c1 == 2) {
                            winnerTxt.text = "${Grid1.namePlayer2} wins"
                            if (isThisTheFirst) {
                                Grid1.player1Turn = false
                                Grid1.player2Turn = false
                                newMatchBtn.isEnabled = true
                                updateGrid()
                            }
                        } else if (Grid1.a1 == 2 && Grid1.b1 == 2 && Grid1.c1 == 2) {
                            winnerTxt.text = "${Grid1.namePlayer2} wins"
                            if (isThisTheFirst) {
                                Grid1.player1Turn = false
                                Grid1.player2Turn = false
                                newMatchBtn.isEnabled = true
                                updateGrid()
                            }
                        } else if (Grid1.a2 == 2 && Grid1.b2 == 2 && Grid1.c2 == 2) {
                            winnerTxt.text = "${Grid1.namePlayer2} wins"
                            if (isThisTheFirst) {
                                Grid1.player1Turn = false
                                Grid1.player2Turn = false
                                newMatchBtn.isEnabled = true
                                updateGrid()
                            }
                        } else if (Grid1.a3 == 2 && Grid1.b3 == 2 && Grid1.c3 == 2) {
                            winnerTxt.text = "${Grid1.namePlayer2} wins"
                            if (isThisTheFirst) {
                                Grid1.player1Turn = false
                                Grid1.player2Turn = false
                                newMatchBtn.isEnabled = true
                                updateGrid()
                            }
                        }


                    }

                }

            }



        newMatchBtn.isEnabled = false


        newMatchBtn.setOnClickListener {

            if (matchCounter == 0.0) {
                Grid1.player1Turn = false
                Grid1.player2Turn = true
                refreshGrid()
                newMatchBtn.isEnabled = false
            } else if (matchCounter == 1.0) {
                Grid1.player1Turn = true
                Grid1.player2Turn = false
                matchCounter -= 2.0
                refreshGrid()
                newMatchBtn.isEnabled = false
            }

            matchCounter ++

        }



        a1Column.setOnClickListener {

            if (Grid1.a1 == 0) {

                if (Grid1.player1Turn && isThisTheFirst) {
                    Grid1.a1 = 1
                    Grid1.player1Turn = false
                    Grid1.player2Turn = true
                    updateGrid()
                } else if (Grid1.player2Turn && !isThisTheFirst) {
                    Grid1.a1 = 2
                    Grid1.player1Turn = true
                    Grid1.player2Turn = false
                    updateGrid()
                }

            }


        }



        a2Column.setOnClickListener {

            if (Grid1.a2 == 0) {

                if (Grid1.player1Turn && isThisTheFirst) {
                    Grid1.a2 = 1
                    Grid1.player1Turn = false
                    Grid1.player2Turn = true
                    updateGrid()
                } else if (Grid1.player2Turn && !isThisTheFirst) {
                    Grid1.a2 = 2
                    Grid1.player1Turn = true
                    Grid1.player2Turn = false
                    updateGrid()
                }

            }

        }

        a3Column.setOnClickListener {

            if (Grid1.a3 == 0) {  // change

                if (Grid1.player1Turn && isThisTheFirst) {
                    Grid1.a3 = 1  // change
                    Grid1.player1Turn = false
                    Grid1.player2Turn = true
                    updateGrid()
                } else if (Grid1.player2Turn && !isThisTheFirst) {
                    Grid1.a3 = 2  // change
                    Grid1.player1Turn = true
                    Grid1.player2Turn = false
                    updateGrid()
                }

            }


        }

        b1Column.setOnClickListener {

            if (Grid1.b1 == 0) {  // change

                if (Grid1.player1Turn && isThisTheFirst) {
                    Grid1.b1 = 1  // change
                    Grid1.player1Turn = false
                    Grid1.player2Turn = true
                    updateGrid()
                } else if (Grid1.player2Turn && !isThisTheFirst) {
                    Grid1.b1 = 2  // change
                    Grid1.player1Turn = true
                    Grid1.player2Turn = false
                    updateGrid()
                }

            }


        }


        b2Column.setOnClickListener {

            if (Grid1.b2 == 0) {  // change

                if (Grid1.player1Turn && isThisTheFirst) {
                    Grid1.b2 = 1  // change
                    Grid1.player1Turn = false
                    Grid1.player2Turn = true
                    updateGrid()
                } else if (Grid1.player2Turn && !isThisTheFirst) {
                    Grid1.b2 = 2  // change
                    Grid1.player1Turn = true
                    Grid1.player2Turn = false
                    updateGrid()
                }

            }


        }

        b3Column.setOnClickListener {

            if (Grid1.b3 == 0) {  // change

                if (Grid1.player1Turn && isThisTheFirst) {
                    Grid1.b3 = 1  // change
                    Grid1.player1Turn = false
                    Grid1.player2Turn = true
                    updateGrid()
                } else if (Grid1.player2Turn && !isThisTheFirst) {
                    Grid1.b3 = 2  // change
                    Grid1.player1Turn = true
                    Grid1.player2Turn = false
                    updateGrid()
                }

            }


        }

        c1Column.setOnClickListener {

            if (Grid1.c1 == 0) {  // change

                if (Grid1.player1Turn && isThisTheFirst) {
                    Grid1.c1 = 1  // change
                    Grid1.player1Turn = false
                    Grid1.player2Turn = true
                    updateGrid()
                } else if (Grid1.player2Turn && !isThisTheFirst) {
                    Grid1.c1 = 2  // change
                    Grid1.player1Turn = true
                    Grid1.player2Turn = false
                    updateGrid()
                }

            }


        }

        c2Column.setOnClickListener {

            if (Grid1.c2 == 0) {  // change

                if (Grid1.player1Turn && isThisTheFirst) {
                    Grid1.c2 = 1  // change
                    Grid1.player1Turn = false
                    Grid1.player2Turn = true
                    updateGrid()
                } else if (Grid1.player2Turn && !isThisTheFirst) {
                    Grid1.c2 = 2  // change
                    Grid1.player1Turn = true
                    Grid1.player2Turn = false
                    updateGrid()
                }

            }


        }


        c3Column.setOnClickListener {

            if (Grid1.c3 == 0) {  // change

                if (Grid1.player1Turn && isThisTheFirst) {
                    Grid1.c3 = 1  // change
                    Grid1.player1Turn = false
                    Grid1.player2Turn = true
                    updateGrid()
                } else if (Grid1.player2Turn && !isThisTheFirst) {
                    Grid1.c3 = 2  // change
                    Grid1.player1Turn = true
                    Grid1.player2Turn = false
                    updateGrid()
                }

            }


        }





    }




    fun updateGrid() {

        val collectiveGrid = grid(a1 = Grid1.a1, a2 = Grid1.a2, a3 = Grid1.a3, b1 = Grid1.b1, b2 = Grid1.b2,
            b3 = Grid1.b3, c1 = Grid1.c1, c2 = Grid1.c2, c3 = Grid1.c3, player1Turn = Grid1.player1Turn, player2Turn = Grid1.player2Turn,
            accepted = Grid1.accepted, isSomebodyPresent = Grid1.isSomebodyPresent, namePlayer1 = Grid1.namePlayer1, namePlayer2 = Grid1.namePlayer2)






        database.collection("Users").document("All players")
            .collection(lobbyName).document(lobbyName).set(collectiveGrid)


            .addOnCompleteListener {


                Log.d("!!!", "item saved")


            }







    }



    fun refreshGrid() {

        val collectiveGrid = grid(a1 = 0, a2 = 0, a3 = 0, b1 = 0, b2 = 0,
            b3 = 0, c1 = 0, c2 = 0, c3 = 0, player1Turn = Grid1.player1Turn, player2Turn = Grid1.player2Turn,
            accepted = Grid1.accepted, isSomebodyPresent = Grid1.isSomebodyPresent, namePlayer1 = Grid1.namePlayer1, namePlayer2 = Grid1.namePlayer2)






        database.collection("Users").document("All players")
            .collection(lobbyName).document(lobbyName).set(collectiveGrid)


            .addOnCompleteListener {


                Log.d("!!!", "item saved")


            }





    }


    override fun onBackPressed() {

        Toast.makeText(this, "This action is not allowed", Toast.LENGTH_SHORT).show()

    }







    fun checkWinner() {



        if (Grid1.a1 > 0 && Grid1.a2 > 0 && Grid1.a3 > 0 && Grid1.b1 > 0 && Grid1.b2 > 0 && Grid1.b3 > 0 && Grid1.c1 > 0 && Grid1.c2 > 0 && Grid1.c3 > 0) {
            winnerTxt.text = "Draw"
            if (isThisTheFirst) {
                Grid1.player1Turn = false
                Grid1.player2Turn = false
                newMatchBtn.isEnabled = true
                updateGrid()
            }
        }


        if (Grid1.a1 == 1 && Grid1.a2 == 1 && Grid1.a3 == 1) {
            winnerTxt.text = "${Grid1.namePlayer1} wins"
            if (isThisTheFirst) {
                Grid1.player1Turn = false
                Grid1.player2Turn = false
                newMatchBtn.isEnabled = true
                updateGrid()
            }
        } else if (Grid1.b1 == 1 && Grid1.b2 == 1 && Grid1.b3 == 1) {
            winnerTxt.text = "${Grid1.namePlayer1} wins"
            if (isThisTheFirst) {
                Grid1.player1Turn = false
                Grid1.player2Turn = false
                newMatchBtn.isEnabled = true
                updateGrid()
            }
        } else if (Grid1.c1 == 1 && Grid1.c2 == 1 && Grid1.c3 == 1) {
            winnerTxt.text = "${Grid1.namePlayer1} wins"
            if (isThisTheFirst) {
                Grid1.player1Turn = false
                Grid1.player2Turn = false
                newMatchBtn.isEnabled = true
                updateGrid()
            }
        } else if (Grid1.a1 == 1 && Grid1.b2 == 1 && Grid1.c3 == 1) {
            winnerTxt.text = "${Grid1.namePlayer1} wins"
            if (isThisTheFirst) {
                Grid1.player1Turn = false
                Grid1.player2Turn = false
                newMatchBtn.isEnabled = true
                updateGrid()
            }
        } else if (Grid1.a3 == 1 && Grid1.b2 == 1 && Grid1.c1 == 1) {
            winnerTxt.text = "${Grid1.namePlayer1} wins"
            if (isThisTheFirst) {
                Grid1.player1Turn = false
                Grid1.player2Turn = false
                newMatchBtn.isEnabled = true
                updateGrid()
            }
        } else if (Grid1.a1 == 1 && Grid1.b1 == 1 && Grid1.c1 == 1) {
            winnerTxt.text = "${Grid1.namePlayer1} wins"
            if (isThisTheFirst) {
                Grid1.player1Turn = false
                Grid1.player2Turn = false
                newMatchBtn.isEnabled = true
                updateGrid()
            }
        } else if (Grid1.a2 == 1 && Grid1.b2 == 1 && Grid1.c2 == 1) {
            winnerTxt.text = "${Grid1.namePlayer1} wins"
            if (isThisTheFirst) {
                Grid1.player1Turn = false
                Grid1.player2Turn = false
                newMatchBtn.isEnabled = true
                updateGrid()
            }
        } else if (Grid1.a3 == 1 && Grid1.b3 == 1 && Grid1.c3 == 1) {
            winnerTxt.text = "${Grid1.namePlayer1} wins"
            if (isThisTheFirst) {
                Grid1.player1Turn = false
                Grid1.player2Turn = false
                newMatchBtn.isEnabled = true
                updateGrid()
            }
        }


        if (Grid1.a1 == 2 && Grid1.a2 == 2 && Grid1.a3 == 2) {
            winnerTxt.text = "${Grid1.namePlayer2} wins"
            if (isThisTheFirst) {
                Grid1.player1Turn = false
                Grid1.player2Turn = false
                newMatchBtn.isEnabled = true
                updateGrid()
            }
        } else if (Grid1.b1 == 2 && Grid1.b2 == 2 && Grid1.b3 == 2) {
            winnerTxt.text = "${Grid1.namePlayer2} wins"
            if (isThisTheFirst) {
                Grid1.player1Turn = false
                Grid1.player2Turn = false
                newMatchBtn.isEnabled = true
                updateGrid()
            }
        } else if (Grid1.c1 == 2 && Grid1.c2 == 2 && Grid1.c3 == 2) {
            winnerTxt.text = "${Grid1.namePlayer2} wins"
            if (isThisTheFirst) {
                Grid1.player1Turn = false
                Grid1.player2Turn = false
                newMatchBtn.isEnabled = true
                updateGrid()
            }
        } else if (Grid1.a1 == 2 && Grid1.b2 == 2 && Grid1.c3 == 2) {
            winnerTxt.text = "${Grid1.namePlayer2} wins"
            if (isThisTheFirst) {
                Grid1.player1Turn = false
                Grid1.player2Turn = false
                newMatchBtn.isEnabled = true
                updateGrid()
            }
        } else if (Grid1.a3 == 2 && Grid1.b2 == 2 && Grid1.c1 == 2) {
            winnerTxt.text = "${Grid1.namePlayer2} wins"
            if (isThisTheFirst) {
                Grid1.player1Turn = false
                Grid1.player2Turn = false
                newMatchBtn.isEnabled = true
                updateGrid()
            }
        } else if (Grid1.a1 == 2 && Grid1.b1 == 2 && Grid1.c1 == 2) {
            winnerTxt.text = "${Grid1.namePlayer2} wins"
            if (isThisTheFirst) {
                Grid1.player1Turn = false
                Grid1.player2Turn = false
                newMatchBtn.isEnabled = true
                updateGrid()
            }
        } else if (Grid1.a2 == 2 && Grid1.b2 == 2 && Grid1.c2 == 2) {
            winnerTxt.text = "${Grid1.namePlayer2} wins"
            if (isThisTheFirst) {
                Grid1.player1Turn = false
                Grid1.player2Turn = false
                newMatchBtn.isEnabled = true
                updateGrid()
            }
        } else if (Grid1.a3 == 2 && Grid1.b3 == 2 && Grid1.c3 == 2) {
            winnerTxt.text = "${Grid1.namePlayer2} wins"
            if (isThisTheFirst) {
                Grid1.player1Turn = false
                Grid1.player2Turn = false
                newMatchBtn.isEnabled = true
                updateGrid()
            }
        }











    }




}