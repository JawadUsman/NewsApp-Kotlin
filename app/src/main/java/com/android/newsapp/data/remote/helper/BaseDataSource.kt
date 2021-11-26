package com.android.newsapp.data.remote.helper

import retrofit2.HttpException
import retrofit2.Response

/**
 * The class BaseDataSource
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 *
 * Abstract Base API Data source class with error handling
 */

abstract class BaseDataSource constructor(
    private val networkHandler: NetworkHandler
) {
    protected suspend fun <T> getResult(call: suspend () -> Response<T>): APIResult<T> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> {
                try {
                    val response = call()
                    if (response.isSuccessful) {
                        val body = response.body()
                        if (body != null) return APIResult.success(body)
                    }
                    return error("Error code: ${response.code()}, \nmessage: ${response.message()}")
                } catch (throwable: Throwable) {
                    when (throwable) {
                        is HttpException -> {
                            val errorResponse = throwable.message()
                            error("Network call has failed for a following reason: $errorResponse")
                        }
                        else -> {
                            error("Server error")
                        }
                    }
                }
            }
            false -> {
                error("No network connection")
            }
        }
    }

    private fun <T> error(message: String): APIResult<T> {
        return APIResult.error(message)
    }
}