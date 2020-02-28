package com.example.codechallenge.repository

import com.example.apilibrary.Event
import com.example.codechallenge.api.ApiService
import com.example.codechallenge.api.RetrofitClient
import io.reactivex.Observable

open class Repository(private val retrofitClient: RetrofitClient) : ApiService {
    override fun getSearchResults(): Observable<List<Event>> {
        return retrofitClient.instance.getSearchResults()
    }
}