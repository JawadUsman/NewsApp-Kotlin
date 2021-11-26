package com.android.newsapp.di

import com.android.newsapp.BuildConfig
import com.android.newsapp.data.remote.dataSource.NewsDataSource
import com.android.newsapp.data.remote.helper.NetworkHandler
import com.android.newsapp.data.remote.service.APIServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

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

    @Provides
    @Singleton
    fun providesAPIServices(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ) = provideServices(okHttpClient, gsonConverterFactory, APIServices::class.java)

    @Provides
    @Singleton
    fun provideNewsDataSource(networkHandler: NetworkHandler, apiServices: APIServices) = NewsDataSource(networkHandler, apiServices)

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