package com.example.apilibrary

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Event(

    @SerializedName("created-at")
    val createdAt: Int,
    val id: Int,
    val title: String,
    val participants: Int,
    val ttl: Int
) : Serializable

