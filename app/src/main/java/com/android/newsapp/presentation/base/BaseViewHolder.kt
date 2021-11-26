package com.android.newsapp.presentation.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * The class BaseViewHolder
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 */
abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: Any)
}