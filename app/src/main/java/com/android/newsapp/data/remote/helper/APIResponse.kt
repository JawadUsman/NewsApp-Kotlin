package com.android.newsapp.data.remote.helper

/**
 * The class Response
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 */
data class APIResponse<T>(
    val copyright: String,
    val num_results: Int,
    val results: List<T>,
    val status: String
)