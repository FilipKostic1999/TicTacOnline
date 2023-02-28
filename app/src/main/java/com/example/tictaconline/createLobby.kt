package com.example.tictaconline

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class createLobby : AppCompatActivity() {



    lateinit var createLobbyET : TextView
    lateinit var joinLobbyET : TextView
    lateinit var createLobbyBtn : Button
    lateinit var joinLobbyBtn : Button


    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var database: FirebaseFirestore


    lateinit var nameInDb : username



    var newLobbyName = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_lobby2)


        createLobbyET = findViewById(R.id.createLobbyET)
        joinLobbyET = findViewById(R.id.joinLobbyET)
        createLobbyBtn = findViewById(R.id.createLobbyBtn)
        joinLobbyBtn = findViewById(R.id.joinLobbyBtn)


        database = Firebase.firestore
        firebaseAuth = FirebaseAuth.getInstance()
        firebaseAuth = Firebase.auth

        val user = firebaseAuth.currentUser


        val sharedLobby = getSharedPreferences("SelectedLobby", AppCompatActivity.MODE_PRIVATE)
        var SelectedLobby = sharedLobby.getString("SelectedLobby", "")


        val sharedName = getSharedPreferences("Name", AppCompatActivity.MODE_PRIVATE)
        var Name = sharedName.getString("Name", "")



        createLobbyBtn.setOnClickListener {

            newLobbyName = createLobbyET.text.toString()
            createLobby()

        }



        joinLobbyBtn.setOnClickListener {

            SelectedLobby = joinLobbyET.text.toString()

            val editSelectedLobby = sharedLobby.edit()
            editSelectedLobby.putString("SelectedLobby", SelectedLobby)
            editSelectedLobby.commit()

            val intent = Intent(this, onlineMultiplayer :: class.java)
            startActivity(intent)


        }




        if (user != null) {

            database.collection("Users").document(user.uid)
                .collection("user name")

                .addSnapshotListener { snapshot, e ->
                    if (snapshot != null) {
                        for (document in snapshot.documents) {

                            nameInDb = document.toObject()!!


                            val editName = sharedName.edit()
                            editName.putString("Name", nameInDb.name)
                            editName.commit()


                        }
                    }
                }
        }










    }


    @SuppressLint("SuspiciousIndentation")
    fun createLobby() {

        val gridUser = grid(a1 = 0, a2 = 0, a3 = 0, b1 = 0, b2 = 0, b3 = 0, c1 = 0, c2 = 0, c3 = 0,
            player1Turn = false, player2Turn = false, accepted = false, isSomebodyPresent = false, namePlayer1 = "", namePlayer2 = "")






            database.collection("Users").document("All players")
                .collection(newLobbyName).document(newLobbyName).set(gridUser)


                .addOnCompleteListener {


                    Log.d("!!!", "item saved")


                }





    }










}