package com.android.newsapp.presentation.newsArticle.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.newsapp.data.remote.helper.APIResult
import com.android.newsapp.domain.model.NewsArticle
import com.android.newsapp.domain.usecase.NewsArticlesUseCase
import com.android.newsapp.presentation.base.BaseViewModel
import com.android.newsapp.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * The class NewsArticleViewModel
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 27 Nov 2021
 */
@HiltViewModel
class NewsArticleViewModel @Inject constructor(private val newsArticlesUseCase: NewsArticlesUseCase) :
    BaseViewModel() {
    private var _progressStatus: MutableLiveData<Event<Boolean>> = MutableLiveData()
    private var _apiMessage: MutableLiveData<Event<String>> = MutableLiveData()
    private var _newsArticleList: MutableLiveData<List<NewsArticle>> = MutableLiveData()

    val getProgressStatus: LiveData<Event<Boolean>> get() = _progressStatus

    val getAPIMessage: LiveData<Event<String>> get() = _apiMessage

    val getNewsArticle: LiveData<List<NewsArticle>> get() = _newsArticleList

    /**
     * Load Most popular new  article
     * @param period
     */
    fun loadNewsArticle(period: Int) {
        newsArticlesUseCase(period, viewModelScope) {
            when (it.status) {
                APIResult.Status.SUCCESS -> {
                    _progressStatus.value = Event(false)
                    _newsArticleList.value = it.data!!
                }
                APIResult.Status.ERROR -> {
                    _progressStatus.value = Event(false)
                    _apiMessage.value = Event(it.message!!)
                }
                APIResult.Status.LOADING -> _progressStatus.value = Event(true)
            }
        }
    }
}