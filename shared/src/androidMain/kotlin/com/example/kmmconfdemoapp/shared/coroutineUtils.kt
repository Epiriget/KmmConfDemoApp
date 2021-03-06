package com.example.kmmconfdemoapp.shared

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

actual class NSLooperDispatcher actual constructor(): CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        runBlocking {
            block.run()
        }
    }
}
