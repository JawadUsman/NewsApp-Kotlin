package com.android.newsapp.presentation

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.android.newsapp.R
import com.android.newsapp.presentation.base.BaseFragment


class SplashFragment : BaseFragment() {
    override val layoutId: Int
        get() = R.layout.fragment_splash

    /**
     * Initialize Presenter methods
     *
     *  Call initialize all and set view to observer on data change in the view model
     *  Passing view from BaseFragment in onCreateView function
     * @param view
     */
    override fun initializePresenter(view: View) {

    }

    override fun onResume() {
        super.onResume()
        navigateToHomeScreen()
    }

    /**
     * navigate to home screen after 2 sec
     */
    private fun navigateToHomeScreen() {
        Handler(Looper.myLooper()!!).postDelayed({
            val action = SplashFragmentDirections.actionSplashFragmentToNewsArticleFragment()
            lifecycleScope.launchWhenResumed {
                findNavController().navigate(action)
            }
        }, 1500)
    }
}