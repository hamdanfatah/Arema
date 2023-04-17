package com.hamdanfatah.arema

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(val name:String, val lastChat:String, val img: Int):Parcelable