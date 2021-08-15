package com.mistplay.challenge.ui.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mistplay.challenge.R

/**
 * UI Binder Class For Binding UI Elements To The View
 *
 * Created by Pramod Selvaraj on 13/08/2021.
 */
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    Glide.with(view.context)
        .load(imageUrl)
        .placeholder(R.drawable.ic_placeholder)
        .into(view)
}