package com.android.newsapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.newsapp.R
import com.android.newsapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * The class MainActivity (Host Activity)
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }
}