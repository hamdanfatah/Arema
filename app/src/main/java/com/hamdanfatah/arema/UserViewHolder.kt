package com.hamdanfatah.arema

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserViewHolder(private  val v: View) : RecyclerView.ViewHolder(v) {
    private val image: ImageView = v.findViewById(R.id.image)
    private val nama: TextView = v.findViewById(R.id.name)
    private val lastChat: TextView = v.findViewById(R.id.lastchat)


    fun onBind(data: User){
        this.nama.text = data.name
        this.lastChat.text = data.lastChat

        this.image.setImageResource(data.img)
    }



}