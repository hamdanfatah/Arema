package com.hamdanfatah.arema

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var rvUser:RecyclerView?=null
    private lateinit var mediaPlayer: MediaPlayer
    private fun startMusic() {
        mediaPlayer = MediaPlayer.create(this, R.raw.lagu1)
        mediaPlayer.isLooping = false // membuat musik diulang-ulang secara otomatis
        mediaPlayer.start() // memulai pemutaran musik
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.rvUser)
        startMusic()

        val data = mutableListOf<User>(

            User("Adilson Maringga", "\"Adilson Aguero dos Santos (lahir 22 Agustus 1990 di Maringá) atau juga dikenal sebagai Adilson Maringá, adalah pemain sepak bola asal Brasil yang bermain sebagai penjaga gawang untuk Arema FC di Liga 1. \"\n",  R.drawable.user1),
            User("Sérgio Silva", "\"Sérgio Domingos Reis Silva (lahir 26 Februari 1994), biasa dikenal sebagai Sérgio Silva, adalah pemain sepak bola asal Portugal yang bermain sebagai bek di Liga 1 untuk Arema. Pada 22 Agustus 2021, \"", R.drawable.user2),
            User("Abel Camara", "\"Abel Camará (lahir 6 Januari 1990) adalah pemain sepak bola profesional asal Guinea-Bissau yang bermain sebagai penyerang untuk Arema di Liga 1. Abel memiliki kulit hitam gelap dan badan yang besar\"", R.drawable.user3),
            User("Rensi Yamaguchi", "\"Renshi Yamaguchi (山口 廉史 Yamaguchi Renshi, lahir 16 September 1992) adalah pemain sepak bola profesional asal Jepang yang bermain untuk Arema di Liga 1. Rensi memiliki jiwa petarung dan fisik yang kuat\"", R.drawable.user4),
            User("Gian Zola", "\"Gian Zola Nasrulloh Nugraha adalah pemain sepak bola profesional berposisi gelandang seran yang bermain untuk Arema di Liga 1. Ia merupakan kakak kandung dari pesepakbola profesional Beckham Putra Nugraha\"", R.drawable.user5),
            User("Seiya Lay", "\"Seiya Da Costa Lay (Jepang: セイヤダコスタレイ; lahir 30 September 2001) adalah pemain sepak bola profesional yang bermain sebagai gelandang bertahan untuk Arema di Liga 1. Seiya merupakan jebolan akademi arema\"", R.drawable.user6),
            User("Evan Dimas", "\"EvanDimas Darmono adalah pemain sepak bola profesional Indonesia yang bermain untuk Arema dan tim nasional Indonesia pada posisi gelandang. Ia sempat mengalami cedera panjang selama semusim, yang membuatnya trauma\"", R.drawable.user7),
            User("Rizky Dwi", "\"Rizky Dwi Febrianto adalah pemain sepak bola profesional Indonesia yang saat ini bermain untuk Arema di Liga 1 dan tim nasional Indonesia sebagai bek kanan. Ia memiliki kemampuan tendangan freekick yang indah\"", R.drawable.user8),
            User("Bagas Adi", "\"Bagas Adi Nugroho adalah pemain sepak bola Indonesia yang berposisi sebagai bek yang sekarang bermain untuk Arema FC di Liga 1 dan Tim nasional sepak bola Indonesia. Bagas selalu unggul duel dengan penyerang\"", R.drawable.user9),
            User("Johan Al-Farizi", "\"Johan Ahmat Al-Farizi atau sering dipanggil dengan Alfarizi adalah seorang pemain sepak bola Indonesia yang bermain sebagai bek kiri untuk Arema di Liga 1. AlFarizi sangat setia dengan arema dari awal karirnya\"", R.drawable.user10),



        )

        val adapter = UserAdapter(data){ myData ->
            Intent(this, DetailActivity::class.java).apply {
                putExtra("user", myData)
                startActivity(this)
            }
        }

        rvUser?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        rvUser?.adapter = adapter

        val serviceIntent = Intent(this, MusicService::class.java)
        startService(serviceIntent)

        val serviceIntent1 = Intent(this, MusicService::class.java)
        stopService(serviceIntent)


    }
}