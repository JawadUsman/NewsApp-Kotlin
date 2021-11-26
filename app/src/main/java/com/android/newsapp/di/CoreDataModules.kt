package com.android.newsapp.di

import com.android.newsapp.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * The class CoreDataModules
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 */
@Module
@InstallIn(SingletonComponent::class)
class CoreDataModules {

    @Provides
    fun provideOkhttp(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
    }

    @Provides
    @Singleton
    fun providsGSON() = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson) = GsonConverterFactory.create()
}