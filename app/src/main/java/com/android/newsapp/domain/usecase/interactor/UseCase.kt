package com.android.newsapp.domain.usecase.interactor

import com.android.newsapp.data.remote.helper.APIResult
import kotlinx.coroutines.*

/**
 * The class UseCase
 *
 * @author Jawad Usman
 * @web www.jawadusman.com
 * @version 1.0
 * @since 26 Nov 2021
 *
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This abstraction represents an execution unit for different use cases (this means that any use
 * case in the application should implement this contract).
 *
 * By convention each [UseCase] implementation will execute its job in a background thread
 * (kotlin coroutine) and will post the result in the UI thread.
 */
abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): APIResult<Type>

    operator fun invoke(
        params: Params,
        scope: CoroutineScope,
        onResult: (APIResult<Type>) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            onResult(APIResult.loading())
            val deferred = async(Dispatchers.IO) {
                run(params)
            }
            onResult(deferred.await())
        }
    }
    class None
}