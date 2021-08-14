package com.mistplay.challenge.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    @SerializedName("list_title")
    val categoryTitle: String,
    @SerializedName("games")
    val games: List<Games>
) : Parcelable