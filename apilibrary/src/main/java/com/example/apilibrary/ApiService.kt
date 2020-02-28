package com.example.codechallenge.api

import com.example.apilibrary.Event
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("/v1/events/search")
    fun getSearchResults(): Observable<List<Event>>
}