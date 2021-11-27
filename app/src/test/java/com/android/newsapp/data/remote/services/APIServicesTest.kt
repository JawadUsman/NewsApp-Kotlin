package com.android.newsapp.data.remote.services

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android.newsapp.data.remote.service.APIServices
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * The class APIServicesTest
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 27 Nov 2021
 */

@RunWith(JUnit4::class)
class APIServicesTest {
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var service: APIServices
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun createService() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIServices::class.java)
    }

    @Test
    fun `should fail when get new article list API request when getNewsList returns with failure result`() {
        runBlocking {
            enqueueResponse("newsArticle.json")
            val resultResponse = service.getNewsList(PERIOD, DUMMY_API_KEY)
            val request = mockWebServer.takeRequest()
            Assert.assertNotNull(resultResponse)
            MatcherAssert.assertThat(
                request.path,
                CoreMatchers.`is`(CoreMatchers.not("sample/test.json"))
            )
        }
    }

    @Test
    fun `should pass when new article list API request when getNewsList() returns with success result`() {
        runBlocking {
            enqueueResponse("newsArticle.json")
            val resultResponse = service.getNewsList(PERIOD, DUMMY_API_KEY)
            val request = mockWebServer.takeRequest()
            Assert.assertNotNull(resultResponse)
            MatcherAssert.assertThat(
                request.path,
                CoreMatchers.`is`(NEWS_LIST_PATH)
            )
        }
    }

    @Test
    fun `get getNewsList success returns with success with inappropriate data size`() {
        val currencyListSize = 15
        runBlocking {
            enqueueResponse("newsArticle.json")
            val resultResponse = service.getNewsList(PERIOD, DUMMY_API_KEY).body()
            val currencyListData = resultResponse!!
            MatcherAssert.assertThat(
                currencyListData.results.size,
                CoreMatchers.`is`(CoreMatchers.not(currencyListSize))
            )
        }
    }

    @Test
    fun `get getNewsList success returns with success with appropriate data size`() {
        val currencyListSize = 5
        runBlocking {
            enqueueResponse("newsArticle.json")
            val resultResponse = service.getNewsList(PERIOD, DUMMY_API_KEY).body()
            val currencyListData = resultResponse!!
            MatcherAssert.assertThat(
                currencyListData.results.size,
                CoreMatchers.`is`(currencyListSize)
            )
        }
    }

    private fun enqueueResponse(fileName: String, headers: Map<String, String> = emptyMap()) {
        val inputStream = javaClass.classLoader!!
            .getResourceAsStream("api-response/$fileName")
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        for ((key, value) in headers) {
            mockResponse.addHeader(key, value)
        }
        mockWebServer.enqueue(
            mockResponse.setBody(
                source.readString(Charsets.UTF_8)
            )
        )
    }

    @After
    fun stopService() {
        mockWebServer.shutdown()
    }

    companion object {
        private const val PERIOD = 7
        private const val DUMMY_API_KEY = "12334"
        private const val NEWS_LIST_PATH = "/svc/mostpopular/v2/mostviewed/all-sections/$PERIOD.json?api-key=$DUMMY_API_KEY"
    }
}