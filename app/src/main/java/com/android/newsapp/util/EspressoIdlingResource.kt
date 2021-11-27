package com.android.newsapp.util

import androidx.test.espresso.IdlingResource

/**
 * The class EspressoIdlingResource
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 27 Nov 2021
 *
 * Contains a static reference to [IdlingResource], only available in the 'mock' build type.
 */
class EspressoIdlingResource {
    companion object INSTANCE {
        private const val RESOURCE = "GLOBAL"

        private val mCountingIdlingResource = SimpleCountingIdlingResource(RESOURCE)

        val idlingResource: IdlingResource
            get() = mCountingIdlingResource

        fun increment() {
            mCountingIdlingResource.increment()
        }

        fun decrement() {
            mCountingIdlingResource.decrement()
        }
    }
}