package com.android.newsapp.presentation.newsArticle.adapter

import android.view.View
import com.android.newsapp.data.model.Media
import com.android.newsapp.domain.model.NewsArticle
import com.android.newsapp.presentation.base.BaseViewHolder
import com.android.newsapp.presentation.loadImageInRoundShape
import kotlinx.android.synthetic.main.adapter_news_article_item.view.*

/**
 * The class NewArticleViewHolder
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 27 Nov 2021
 *
 * Called when onBindViewHolder is triggered in RecyclerView adapter
 * The new bind will be used to set the values to display items
 */
class NewsArticleViewHolder(itemView: View) : BaseViewHolder<Any?>(itemView) {
    override fun bind(item: Any) {
        val newsArticle = item as NewsArticle
        itemView.tvTitle.text = newsArticle.title
        itemView.tvSource.text = newsArticle.source
        itemView.tvByLine.text = newsArticle.byline
        itemView.tvPublishedDate.text = newsArticle.published_date
        newsArticle.media.forEach mainLoop@{ media ->
            media.media_metadata.forEach { mediaMetadata ->
                if (mediaMetadata.format == "Standard Thumbnail") {
                    itemView.ivMedia.loadImageInRoundShape(mediaMetadata.url)
                    return@mainLoop
                }
            }
        }
    }
}