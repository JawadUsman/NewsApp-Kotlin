package com.android.newsapp.presentation

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * The class Extensions
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 */

fun ImageView.loadImage(url: String) = Glide.with(this.context).load(url).into(this)