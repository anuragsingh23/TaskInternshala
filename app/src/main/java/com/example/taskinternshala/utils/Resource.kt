package com.example.taskinternshala.utils
/*
A Sealed class using generics for the class, so that it can be reused for different response types.
 */
sealed class Status<out T> {
    /**
     * Success response with body
     */
    data class Success<out T>(val value: T): Status<T>()
    /**
     * Failure response with body
     */
    data class Failure(val code: Int? = null, val error: String? = null, val rawResponse: String? = null): Status<Nothing>()
    /**
     * Network error
     */
    object NetworkError: Status<Nothing>()
}
