package com.android.newsapp.domain.usecase

import com.android.newsapp.data.remote.helper.APIResult
import com.android.newsapp.domain.model.News
import com.android.newsapp.domain.repository.NewsArticlesRepository
import com.android.newsapp.domain.usecase.interactor.UseCase
import javax.inject.Inject

/**
 * The class GetNewsArticles
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 */
class NewsArticlesUseCase @Inject constructor(private val repository: NewsArticlesRepository) :
    UseCase<List<News>, Int>() {

    override suspend fun run(params: Int): APIResult<List<News>> = repository.getNewsArticle(params)

}