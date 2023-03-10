package com.example.tictaconline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tictaconline.databinding.ActivityLogInBinding
import com.example.tictaconline.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    lateinit var database : FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()




        database = Firebase.firestore
        firebaseAuth = Firebase.auth









        binding.signInTxt.setOnClickListener {


            val intent = Intent(this, ActivityLogInBinding::class.java)

            startActivity(intent)
        }










        binding.signUpWorkerBut.setOnClickListener {
            val email = binding.workerSignUpEmailEditTexst.text.toString()
            val pass = binding.workerSignUpPasEditTexst.text.toString()
            val confirmPass = binding.workerSignUpPas2EditTexst.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {

                if (pass == confirmPass) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {




                            val intent = Intent(this, createUsername::class.java)

                            startActivity(intent)



                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Pasword does not mach", Toast.LENGTH_SHORT).show()
                }


            } else {
                Toast.makeText(this, "there are empty fields", Toast.LENGTH_SHORT).show()
            }

        }
    }
}

