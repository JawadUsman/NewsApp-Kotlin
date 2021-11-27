package com.android.newsapp.presentation

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.android.newsapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

/**
 * The class Extensions
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 */

fun ImageView.loadImage(url: String?) =
    Glide.with(this.context.applicationContext)
        .load(url).transition(DrawableTransitionOptions.withCrossFade())
        .placeholder(R.color.textGray)
        .error(R.color.textGray)
        .into(this)

fun ImageView.loadImageInRoundShape(url: String?) =
    Glide.with(this.context.applicationContext)
        .load(url).transition(DrawableTransitionOptions.withCrossFade())
        .placeholder(R.drawable.shape_round_gray)
        .error(R.drawable.shape_round_gray)
        .circleCrop()
        .into(this)

fun View.isVisible() = this.visibility == View.VISIBLE

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.GONE
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)