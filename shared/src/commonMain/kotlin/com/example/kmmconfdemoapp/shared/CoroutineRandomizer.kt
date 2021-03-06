package com.example.kmmconfdemoapp.shared

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.random.Random

class CoroutineRandomizer {
    var counter: Int = MIN_VALUE

    @Throws(Exception::class)
    suspend fun generate() = generate(counter)

    private suspend fun generate(counter: Int) =
        withContext(Dispatchers.Default) {
            var localCounter = counter
            localCounter += Random(MAX_VALUE).nextInt() % 10
            localCounter += Random(MAX_VALUE).nextInt() % 10
            delay(DELAY_MS)
            return@withContext localCounter.toString()
        }


    companion object {
        private const val MIN_VALUE = 0
        private const val MAX_VALUE = 1000
        private const val DELAY_MS: Long = 2000
    }
}