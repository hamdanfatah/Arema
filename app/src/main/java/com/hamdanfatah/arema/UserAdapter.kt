package com.hamdanfatah.arema

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
    private val data:MutableList<User>,
    private val listener: (User) -> Unit
): RecyclerView.Adapter <UserViewHolder>(){

    // Create View Holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view,parent,false)
        )
    // Method adalah untuk menampilkan berapa item yang mau kita tampilkan
    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind(data[position])
        holder.itemView.setOnClickListener{
            listener(data[position])
        }
    }
}