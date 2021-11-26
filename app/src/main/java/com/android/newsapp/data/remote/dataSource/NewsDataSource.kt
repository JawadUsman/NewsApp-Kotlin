package com.android.newsapp.data.remote.dataSource

import com.android.newsapp.data.remote.helper.BaseDataSource
import com.android.newsapp.data.remote.helper.NetworkHandler
import com.android.newsapp.data.remote.service.APIServices
import javax.inject.Inject

/**
 * The class NewsDataSource
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 */
class NewsDataSource @Inject constructor(
    networkHandler: NetworkHandler,
    private val apiServices: APIServices
) : BaseDataSource(networkHandler) {
    suspend fun geNewsList(apiKey: String, period: Int) = getResult {
        apiServices.getNewsList(apiKey, period)
    }
}