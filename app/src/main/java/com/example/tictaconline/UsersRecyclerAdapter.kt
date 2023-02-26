package com.example.tictaconline

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsersRecyclerAdapter(val context: Context, val users: List<User>) :

    RecyclerView.Adapter<UsersRecyclerAdapter.ViewHolder>() {

    val layoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.list_item, parent, false)
        Log.d("!!!", "oncreateViewholder")

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("!!!Adapter", "oncreateViewHolder $position")

        //när en lis_view ska visas så tror vi rätt person från vår lista
        val user = users[position]

        //sätt in där persons uppgifter i vår view
        holder.nameTextView.text = user.name
        holder.ageTextView.text = user.age.toString()

    }

    override fun getItemCount(): Int {
        return users.size
    }

    //skapa vår inner klass i vår klass
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)
        var ageTextView = itemView.findViewById<TextView>(R.id.ageTextView)
    }
}