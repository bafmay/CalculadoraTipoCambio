package com.retobcp.core.data.utils

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.Cache
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val CONTENT_TYPE_JSON = "application/json"

fun createRetrofitNew(httpClient: OkHttpClient, baseUrl: String): Retrofit {
    val contentType = MediaType.get(CONTENT_TYPE_JSON)
    val gson = GsonBuilder()
        .create()
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addConverterFactory(
            Json(JsonConfiguration(strictMode = false)).asConverterFactory(contentType)
        )
        .client(httpClient)
        .build()
}

fun createOkHttpClient(
    cache: Cache? = null,
    f: (Request.Builder.() -> Request.Builder)? = null
): OkHttpClient {
    return OkHttpClient.Builder()
        .retryOnConnectionFailure(true)
        .cache(cache)
        .addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
            val request = (f?.invoke(requestBuilder) ?: requestBuilder)
                .removeHeader("Content-Type")
                .addHeader("Accept", CONTENT_TYPE_JSON)
                .addHeader("Content-Type", CONTENT_TYPE_JSON)
            chain.proceed(request.build())
        }
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .readTimeout(3, TimeUnit.MINUTES)
        .connectTimeout(5, TimeUnit.MINUTES)
        .build()
}

suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): T? {
    try {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()
        } else {
            throw HttpException(response)
        }
    } catch (e: Exception) {
        e.printStackTrace()
        throw e
    }
}