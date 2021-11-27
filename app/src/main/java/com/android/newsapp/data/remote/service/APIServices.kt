package com.android.newsapp.data.remote.service

import com.android.newsapp.data.model.NewsEntity
import com.android.newsapp.data.remote.helper.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * The class APIServices
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 */
interface APIServices {
    companion object {
        private const val PERIOD = "period"
        private const val API_KEY = "api-key"
        private const val NEWS_LIST = "svc/mostpopular/v2/mostviewed/all-sections/{$PERIOD}.json"
    }

    @GET(NEWS_LIST)
    suspend fun getNewsList(
        @Path(PERIOD) period: Int,
        @Query(API_KEY) apiKey: String
    ): Response<APIResponse<NewsEntity>>
}