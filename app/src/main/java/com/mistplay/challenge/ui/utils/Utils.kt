package com.mistplay.challenge.ui.utils

import android.content.Context
import java.io.IOException

object Utils {
    /**
     * Function for Fetching Json Data From Assets Folder
     */
    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}