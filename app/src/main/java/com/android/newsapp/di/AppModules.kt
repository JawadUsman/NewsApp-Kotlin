package com.android.newsapp.di

import com.android.newsapp.BuildConfig
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * The class AppModules
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 */
@Module(includes = [CoreDataModules::class])
@InstallIn(SingletonComponent::class)
object AppModules {

    private fun <T> provideServices(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory, newClass: Class<T>
    ) = createRetrofit(okHttpClient, gsonConverterFactory).create(newClass)

    private fun createRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ) =
        Retrofit.Builder().baseUrl(BuildConfig.API_BASE_URL).client(okHttpClient)
            .addConverterFactory(gsonConverterFactory).build()
}