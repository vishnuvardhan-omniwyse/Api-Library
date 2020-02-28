package com.example.apilibrary

import io.reactivex.Observable

open class Repository(private val retrofitClient: RetrofitClient) : ApiService {
    override fun getSearchResults(): Observable<List<Event>> {
        return retrofitClient.instance.getSearchResults()
    }
}