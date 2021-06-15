package com.example.kmmconfdemoapp.shared;

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

expect class NSLooperDispatcher(): CoroutineDispatcher

internal class MainScope: CoroutineScope {
    private val dispatcher = NSLooperDispatcher()
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = dispatcher + job
}
