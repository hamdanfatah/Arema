package com.hamdanfatah.arema

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicService : Service() {
    // Deklarasi MediaPlayer dan variabel lainnya
    private lateinit var mediaPlayer: MediaPlayer

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        // Inisialisasi MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.lagu1)
        mediaPlayer.isLooping = true // membuat musik diulang-ulang secara otomatis
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Memulai pemutaran musik
        mediaPlayer.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        // Menghentikan pemutaran musik
        mediaPlayer.stop()
        mediaPlayer.release()
    }
}
