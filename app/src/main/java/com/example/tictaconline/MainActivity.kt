package com.example.tictaconline

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)








    }

    fun openNextActivity1(view: View) {
        val intent = Intent(this, MultiplayerActivity::class.java)
        startActivity(intent)
    }

    fun openNextActivity2(view: View) {
        val intent = Intent(this, RecycleViewUsersActivity::class.java)
        startActivity(intent)
    }
        fun openNextActivity4(view: View) {
            val intent = Intent(this, StatsActivity::class.java)
            startActivity(intent)
        }


    }
