package com.android.newsapp.domain.model

import com.android.newsapp.data.model.Media
import com.google.gson.annotations.SerializedName

/**
 * The class News
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 */
data class NewsArticle(
    val title: String,
    @SerializedName("abstract")
    val abstractValue: String,
    val adx_keywords: String,
    val published_date: String,
    val byline: String,
    val source: String,
    val url: String,
    val media: List<Media>
)