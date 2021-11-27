package com.android.newsapp.data.remote.helper

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * The class APIResultTest
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 27 Nov 2021
 */

@RunWith(JUnit4::class)
class APIResultTest {

    @Test
    fun `APIResult should return same instance for success type`() {
        val result = APIResult.success(DUMMY_DATA)
        MatcherAssert.assertThat(result, CoreMatchers.`is`(instanceOf((APIResult::class.java))))
        MatcherAssert.assertThat(result.status, CoreMatchers.`is`(APIResult.Status.SUCCESS))
        MatcherAssert.assertThat(result.data, CoreMatchers.`is`(DUMMY_DATA))
    }

    @Test
    fun `APIResult should return wrong type for success type`() {
        val result = APIResult.success(DUMMY_DATA)
        MatcherAssert.assertThat(result.status, CoreMatchers.`is`(CoreMatchers.not(APIResult.Status.ERROR)))
    }

    @Test
    fun `APIResult should return same instance for error type with same error message`() {
        val result = APIResult.error(data = null, message = DUMMY_DATA_ERROR)
        MatcherAssert.assertThat(result, CoreMatchers.`is`(instanceOf((APIResult::class.java))))
        MatcherAssert.assertThat(result.status, CoreMatchers.`is`(APIResult.Status.ERROR))
        MatcherAssert.assertThat(result.message, CoreMatchers.`is`(DUMMY_DATA_ERROR))
    }

    @Test
    fun `APIResult should return same status for error type with different error message`() {
        val result = APIResult.error(data = null, message = DUMMY_DATA_ERROR)
        MatcherAssert.assertThat(result.status, CoreMatchers.`is`(APIResult.Status.ERROR))
        MatcherAssert.assertThat(result.data, CoreMatchers.`is`(CoreMatchers.not(DUMMY_DATA)))
    }

    companion object {
        private const val DUMMY_DATA = "Dummy data"
        private const val DUMMY_DATA_ERROR = "Dummy data error"
    }
}