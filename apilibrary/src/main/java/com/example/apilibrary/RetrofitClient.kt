package com.example.apilibrary

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://private-anon-1105c40a75-tmpz.apiary-mock.com/"
    private const val AUTHORIZATION = "Authorization"
    private const val ACCESS_TOKEN="Bearer e3e4db4432d6f93905f705e53a4898087920b6e71b0ffc4b5451924361c3e86b"

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .addHeader(AUTHORIZATION, ACCESS_TOKEN)
                .method(original.method(), original.body())
                .build()
            chain.proceed(request)
        }.build()

    val instance: ApiService by lazy {
         Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }
}