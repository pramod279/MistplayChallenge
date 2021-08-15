package com.mistplay.challenge.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Games Data Model
 */
@Parcelize
data class Games(
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("img")
    val img: String
) : Parcelable