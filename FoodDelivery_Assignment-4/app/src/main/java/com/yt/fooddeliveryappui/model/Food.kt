package com.yt.fooddeliveryappui.model

import android.os.Parcelable
import com.yt.fooddeliveryappui.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    val name:String,
    val price:Int,
    val returnPolicy:String,
    val image:Int,
    val listOFImages:List<Int>
):Parcelable

val listOfFood = listOf(
    Food(
        "Greek \nFood",
        40,
        "All our foods are double checked before leaving our stores so by any case you found a broken food please contact our hotline immediately.",
        R.drawable.greek,
        listOf(
            R.drawable.greek,
            R.drawable.greek,
            R.drawable.greek
        )
    ),
    Food(
        "Japanese \nFood",
        80,
        "All our foods are double checked before leaving our stores so by any case you found a broken food please contact our hotline immediately.",
        R.drawable.japanese,
        listOf(
            R.drawable.japanese,
            R.drawable.japanese,
            R.drawable.japanese,
        )
    ),
    Food(
        "Indian \nFood",
        90,
        "All our foods are double checked before leaving our stores so by any case you found a broken food please contact our hotline immediately.",
        R.drawable.indian,
        listOf(
            R.drawable.indian,
            R.drawable.indian,
            R.drawable.indian
        )
    ),
    Food(
        "Chinese \nFood",
        100,
        "All our foods are double checked before leaving our stores so by any case you found a broken food please contact our hotline immediately.",
        R.drawable.chinese,
        listOf(
            R.drawable.chinese,
            R.drawable.chinese,
            R.drawable.chinese
        )
    ),
    Food(
        "American \nFood",
        100,
        "All our foods are double checked before leaving our stores so by any case you found a broken food please contact our hotline immediately.",
        R.drawable.american,
        listOf(
            R.drawable.american,
            R.drawable.american,
            R.drawable.american
        )
    )
)