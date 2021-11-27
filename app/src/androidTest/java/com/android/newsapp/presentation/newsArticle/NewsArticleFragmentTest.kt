package com.android.newsapp.presentation.newsArticle

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.android.newsapp.R
import com.android.newsapp.presentation.MainActivity
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * The class NewsArticleFragmentTest
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 27 Nov 2021
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class NewsArticleFragmentTest {

    private var mIdlingResource: IdlingResource? = null

    @get:Rule
    var mActivityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        val activityScenario: ActivityScenario<*> = ActivityScenario.launch(MainActivity::class.java)
        activityScenario.onActivity { activity ->
            mIdlingResource = (activity as MainActivity).countingIdlingResource
            IdlingRegistry.getInstance().register(mIdlingResource)
        }
    }

    @Test
    fun initialTest() {
        Espresso.onView(withId(R.id.tvMessage)).check(
            ViewAssertions.matches(
                CoreMatchers.not(
                    ViewMatchers.isDisplayed())))
        Espresso.onView(withId(R.id.rvNewsArticle)).check(
            ViewAssertions.matches(
                CoreMatchers.not(
                    ViewMatchers.isDisplayed())))
        Espresso.onView(withId(R.id.pbNewsArticleLoader)).check(
            ViewAssertions.matches(
                    ViewMatchers.isDisplayed()))
    }
}