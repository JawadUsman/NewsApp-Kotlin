package com.android.newsapp.presentation.newsArticle

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.android.newsapp.R
import com.android.newsapp.presentation.base.BaseFragment
import com.android.newsapp.presentation.newsArticle.adapter.NewsArticleAdapter
import com.android.newsapp.presentation.newsArticle.viewModel.NewsArticleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_news_article.view.*
import javax.inject.Inject

@AndroidEntryPoint
class NewsArticleFragment : BaseFragment() {

    private val newsArticleViewModel: NewsArticleViewModel by viewModels()
    @Inject
    lateinit var newsArticleAdapter: NewsArticleAdapter

    override val layoutId: Int
        get() = R.layout.fragment_news_article

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadNewsArticleList()
    }

    /**
     * Initialize Presenter methods
     *
     *  Call initialize all and set view to observer on data change in the view model
     *  Passing view from BaseFragment in onCreateView function
     * @param view
     */
    override fun initializePresenter(view: View) {
        view.rvNewsArticle.adapter = newsArticleAdapter
        subscribeUI(view)
    }

    /**
     * Observer all list to update UI on data change. If MutableLiveData already has data
     * set, it will be delivered to the observer.
     * When data changes views will receive the last available data from the server and
     * local database.
     * @param view
     */
    private fun subscribeUI(view: View) {
        with(newsArticleViewModel) {
            getAPIMessage.observe(viewLifecycleOwner) {
                it.getContentIfNotHandled()?.let {

                }
            }

            getProgressStatus.observe(viewLifecycleOwner) {
                it.getContentIfNotHandled()?.let {

                }
            }
            getNewsArticle.observe(viewLifecycleOwner) {
                newsArticleAdapter.listItem = it
            }
        }
    }

    private fun loadNewsArticleList() {
        newsArticleViewModel.loadNewsArticle(7)
    }
}