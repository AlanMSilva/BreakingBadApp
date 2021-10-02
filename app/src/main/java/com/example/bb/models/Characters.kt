package com.example.bb.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Characters (
    val id:Int,
    val name:String,
    val birthday:String,
    //val ocupation:Array<String>,
    val img:String,
    val nickname: String,
    val status:String,
    val portrayed:String

) : Parcelable {
}

