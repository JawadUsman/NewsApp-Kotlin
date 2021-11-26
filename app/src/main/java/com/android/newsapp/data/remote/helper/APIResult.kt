package com.android.newsapp.data.remote.helper

/**
 * The class APIResult
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 *
 * APIResult is usually created by the Repository classes where they return
 * `LiveData<APIResult<T>>` to pass back the latest data to the UI with its fetch status.
 *
 */
data class APIResult<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): APIResult<T> {
            return APIResult(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(message: String, data: T? = null): APIResult<T> {
            return APIResult(
                Status.ERROR,
                data,
                message
            )
        }

        fun <T> loading(data: T? = null): APIResult<T> {
            return APIResult(
                Status.LOADING,
                data,
                null
            )
        }
    }
}
