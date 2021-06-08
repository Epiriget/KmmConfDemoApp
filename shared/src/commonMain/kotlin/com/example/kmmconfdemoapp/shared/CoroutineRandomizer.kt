package com.example.kmmconfdemoapp.shared

import kotlinx.coroutines.*
import kotlin.random.Random


class CoroutineRandomizer {
    var counter: Int = MIN_VALUE

    suspend fun generate() = CoroutineScope(Dispatchers.Main).async {
        counter += Random(MAX_VALUE).nextInt()
        delay(DELAY_MS)
        counter.toString()
    }.await()


    companion object {
        private const val MIN_VALUE = 0
        private const val MAX_VALUE = 1000
        private const val DELAY_MS: Long = 2000
    }
}
