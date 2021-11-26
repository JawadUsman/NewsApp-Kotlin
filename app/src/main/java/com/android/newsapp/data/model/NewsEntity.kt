package com.android.newsapp.data.model

import com.android.newsapp.domain.model.News
import com.google.gson.annotations.SerializedName

/**
 * The class NewsEntity
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 */
data class NewsEntity(
    @SerializedName("abstract")
    val abstractValue: String,
    val adx_keywords: String,
    val asset_id: Long,
    val byline: String,
    val column: Any,
    val des_facet: List<String>,
    val eta_id: Int,
    val geo_facet: List<String>,
    val id: Long,
    val media: List<Media>,
    val nytdsection: String,
    val org_facet: List<String>,
    val per_facet: List<String>,
    val published_date: String,
    val section: String,
    val source: String,
    val subsection: String,
    val title: String,
    val type: String,
    val updated: String,
    val uri: String,
    val url: String
) {
    fun toNewsList() =
        News(title, abstractValue, adx_keywords, published_date, byline, source, url, media)
}