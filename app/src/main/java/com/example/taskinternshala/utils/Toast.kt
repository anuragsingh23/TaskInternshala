package com.example.taskinternshala.utils

import android.widget.Toast
import com.example.taskinternshala.application.TaskApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.time.ExperimentalTime
import kotlin.time.TimeSource


/*
A Toast Singleton object which is using coroutineScope to
Show Toast anytime anywhere
@Params it takes application instance to start coroutineScope to save memory leaks
 */
object Toast {

    private val applicationScope = CoroutineScope(SupervisorJob())

    @OptIn(ExperimentalTime::class)
    private var toastTimeMark = TimeSource.Monotonic.markNow()

    @OptIn(ExperimentalTime::class)
    fun showToast(message: String) {
        applicationScope.launch(Dispatchers.Main) {
            Toast.makeText(TaskApp.instance, message, Toast.LENGTH_SHORT).show()
            toastTimeMark = TimeSource.Monotonic.markNow()
        }
    }
}