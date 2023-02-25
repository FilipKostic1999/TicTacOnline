package com.example.tictaconline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecycleViewUsersActivity : AppCompatActivity() {

    var users = mutableListOf<User>(
        User("Filip",23),
        User("Alex", 34),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view_users)

        for(i in 1..100) {
            users.add(User("Gallorini", i))
        }

        var recyclerView = findViewById<RecyclerView>(R.id.usersRecycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // skapade vi en dator från vår adapter-klass och skickar med vår lista av users
        val adapter = UsersRecyclerAdapter(this, users)

        // koppla ihop adapter med recycleview
        recyclerView.adapter = adapter

        // skapa adapter
        //
    }
}