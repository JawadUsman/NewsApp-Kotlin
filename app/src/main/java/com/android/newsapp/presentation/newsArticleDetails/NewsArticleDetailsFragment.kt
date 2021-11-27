package com.android.newsapp.presentation.newsArticleDetails

import android.content.Intent
import android.view.View
import androidx.navigation.fragment.findNavController
import com.android.newsapp.R
import com.android.newsapp.presentation.base.BaseFragment
import com.android.newsapp.presentation.loadImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_news_article_details.view.*

@AndroidEntryPoint
class NewsArticleDetailsFragment :BaseFragment() {

    override val layoutId: Int
        get() = R.layout.fragment_news_article_details

    /**
     * Initialize Presenter methods
     *
     *  Call initialize all and set view to observer on data change in the view model
     *  Passing view from BaseFragment in onCreateView function
     * @param view
     */
    override fun initializePresenter(view: View) {
        arguments?.let { bundle ->
            NewsArticleDetailsFragmentArgs.fromBundle(bundle).newArticleDetails.let { newsArticle ->
                view.tvDesTitle.text = newsArticle.title
                view.tvDesArticle.text = newsArticle.adx_keywords
                view.tvPublishedDate.text = "Published date: ${newsArticle.published_date}"
                var imageURL: String? = null
                newsArticle.media.forEach mainLoop@{ media ->
                    media.media_metadata.forEach { mediaMetadata ->
                        if (mediaMetadata.format == "mediumThreeByTwo210") {
                            imageURL = mediaMetadata.url
                            return@mainLoop
                        }
                    }
                }

                view.ivMedia.loadImage(imageURL)
                view.tvDescription.text = newsArticle.abstractValue

                view.ivShare.setOnClickListener {
                    shareInformation(
                        "*${newsArticle.title}*",
                        newsArticle.abstractValue,
                        newsArticle.url
                    )
                }
                view.ivBack.setOnClickListener {
                    findNavController().popBackStack()
                }
            }
        }
    }

    /**
     * To share content across multiple channels, including email,
     * text messaging, social networking and more
     *
     * @param title
     * @param subject, content to share the data
     * @param url, URL of the content for more information
     */
    private fun shareInformation(title: String, subject: String, url: String) {
        val shareText =
            title +
                    System.lineSeparator() +
                    System.lineSeparator() +
                    subject +
                    System.lineSeparator() +
                    System.lineSeparator() +
                    url
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, title)
        intent.putExtra(Intent.EXTRA_TEXT, shareText)
        startActivity(Intent.createChooser(intent, "Share via"))
    }
}