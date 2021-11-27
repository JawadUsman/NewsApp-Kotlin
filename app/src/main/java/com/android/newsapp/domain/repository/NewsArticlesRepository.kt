package com.android.newsapp.domain.repository

import com.android.newsapp.BuildConfig
import com.android.newsapp.data.remote.dataSource.NewsDataSource
import com.android.newsapp.data.remote.helper.APIResult
import com.android.newsapp.domain.model.NewsArticle
import java.lang.Exception
import javax.inject.Inject

/**
 * The class NewsArticlesRepository
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 */
class NewsArticlesRepository @Inject constructor(private val newsDataSource: NewsDataSource) {

    /**
     * News Article list API response handled in this function
     * returns News Article list from the server
     * @param period
     */
    suspend fun getNewsArticle(period: Int): APIResult<List<NewsArticle>> {
        return try {
            val response = newsDataSource.geNewsList(BuildConfig.NY_API_KEY, period)
            if (response.status == APIResult.Status.SUCCESS) {
                response.data?.let { currencyList ->
                    val newsArticleList: List<NewsArticle> = currencyList.results.map {
                        it.toNewsList()
                    }
                    if (newsArticleList.isNotEmpty())
                        APIResult.success(newsArticleList)
                    else
                        APIResult.error("No news article found")
                } ?: run {
                    APIResult.error("No data found")
                }
            } else {
                APIResult.error(response.message!!)
            }
        } catch (ex: Exception) {
            APIResult.error("Sorry, something went wrong")
        }
    }
}