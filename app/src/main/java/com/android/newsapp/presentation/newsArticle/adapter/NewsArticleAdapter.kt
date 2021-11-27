package com.android.newsapp.presentation.newsArticle.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.newsapp.R
import com.android.newsapp.domain.model.NewsArticle
import com.android.newsapp.presentation.inflate
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * The class NewArticleAdapter
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 27 Nov 2021
 */
class NewsArticleAdapter @Inject constructor() : RecyclerView.Adapter<NewsArticleViewHolder>() {

    internal var listItem: List<NewsArticle> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsArticleViewHolder(
        parent.inflate(
            R.layout.adapter_news_article_item
        )
    )

    override fun onBindViewHolder(holder: NewsArticleViewHolder, position: Int) =
        holder.bind(listItem[position])

    override fun getItemCount() = listItem.size
}