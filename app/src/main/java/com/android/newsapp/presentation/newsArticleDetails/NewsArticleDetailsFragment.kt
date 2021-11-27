package com.android.newsapp.presentation.newsArticleDetails

import android.view.View
import com.android.newsapp.R
import com.android.newsapp.presentation.base.BaseFragment


class NewsArticleDetailsFragment : BaseFragment() {

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

    }

    /**
     * Observer all list to update UI on data change. If MutableLiveData already has data
     * set, it will be delivered to the observer.
     * When data changes views will receive the last available data from the server and
     * local database.
     * @param view
     */
    private fun subscribeUI(view: View) {

    }
}