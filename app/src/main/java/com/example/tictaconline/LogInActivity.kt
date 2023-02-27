package com.example.tictaconline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tictaconline.databinding.ActivityLogInBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var navigationMenu : BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)







                var auth = FirebaseAuth.getInstance()


                val user = auth.currentUser







                binding = ActivityLogInBinding.inflate(layoutInflater)

                setContentView(binding.root)







                firebaseAuth = FirebaseAuth.getInstance()


                binding.createA.setOnClickListener {
                    val intent = Intent(this, SignUpActivity:: class.java)
                    startActivity(intent)
                }





                binding.workerSignInButton.setOnClickListener {


                    val email = binding.workerSignUpEmailEditTexst.text.toString()
                    val pass = binding.workerSignUpPasEditTexst.text.toString()






                    if (email.isNotEmpty() && pass.isNotEmpty()) {


                        firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                            if (it.isSuccessful) {
                                val intent = Intent(this, createLobby:: class.java)

                                startActivity(intent)
                            } else {
                                Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                            }
                        }
                    } else {
                        Toast.makeText(this, "there are empty fields", Toast.LENGTH_SHORT).show()
                    }

                }











            }






    }
