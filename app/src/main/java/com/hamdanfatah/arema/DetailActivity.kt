package com.hamdanfatah.arema

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val user = intent.getParcelableExtra<User>("user")




        val image = findViewById<ImageView>(R.id.ivFoto)
        val title = findViewById<TextView>(R.id.tvNama)
        val lastchat = findViewById<TextView>(R.id.tvDetail)

        title.text = user?.name
        lastchat.text = user?.lastChat



        image.setImageResource(user?.img!!)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}