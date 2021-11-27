package com.android.newsapp.domain.usecase.interactor

import com.android.newsapp.data.remote.helper.APIResult
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * The class UseCaseTest
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 27 Nov 2021
 */

@RunWith(JUnit4::class)
class UseCaseTest {

    private lateinit var useCase: TestUseCase

    @Before
    fun testUseCase() {
        useCase = TestUseCase()
    }

    @Test
    fun `use case should return 'APIResult' of use case type with success status`() {
        val params = MyParams(TYPE_PARAM)
        val result = runBlocking { useCase.run(params) }
        MatcherAssert.assertThat(
            result,
            CoreMatchers.`is`(APIResult.success(MyType(TYPE_TEST)))
        )
    }

    data class MyType(val name: String)
    data class MyParams(val name: String)

    private inner class TestUseCase : UseCase<MyType, MyParams>() {
        override suspend fun run(params: MyParams) = APIResult.success(MyType(TYPE_TEST))
    }

    companion object {
        private const val TYPE_TEST = "Test"
        private const val TYPE_PARAM = "ParamTest"
    }
}