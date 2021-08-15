package com.mistplay.challenge.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Category Data Model
 */
@Parcelize
data class Category(
    val id: String,
    @SerializedName("list_title")
    val categoryTitle: String,
    @SerializedName("games")
    val games: List<Games>
) : Parcelable