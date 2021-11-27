package com.android.newsapp.presentation

import android.view.View
import android.widget.ImageView
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

fun ImageView.loadImage(url: String) =
    Glide.with(this.context.applicationContext)
        .load(url).transition(DrawableTransitionOptions.withCrossFade())
        .into(this)

fun ImageView.loadImageInRoundShape(url: String) =
    Glide.with(this.context.applicationContext)
        .load(url).transition(DrawableTransitionOptions.withCrossFade())
        .circleCrop()
        .into(this)

fun View.isVisible() = this.visibility == View.VISIBLE

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.GONE
}