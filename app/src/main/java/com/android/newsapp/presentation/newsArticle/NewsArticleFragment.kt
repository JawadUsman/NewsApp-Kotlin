package com.android.newsapp.presentation.newsArticle

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.android.newsapp.R
import com.android.newsapp.presentation.base.BaseFragment
import com.android.newsapp.presentation.newsArticle.viewModel.NewsArticleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsArticleFragment : BaseFragment() {

    private val newsArticleViewModel: NewsArticleViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.fragment_news_article

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadMoviesList()
    }

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

    private fun loadMoviesList() {
//        emptyView.invisible()
//        movieList.visible()
        newsArticleViewModel.loadNewsArticle(7)
    }
}