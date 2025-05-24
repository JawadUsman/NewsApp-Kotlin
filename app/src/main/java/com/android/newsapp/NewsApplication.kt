package com.android.newsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * The class NewsApplication
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 */
import leakcanary.LeakCanary

@HiltAndroidApp
class NewsApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        LeakCanary.config = LeakCanary.config.copy(dumpHeap = true)
    }
}