package com.example.chewbaccaapp.data.network

import com.example.chewbaccaapp.data.network.models.PeopleList
import retrofit2.http.GET

interface StarWarsApi {

    @GET("/people")
    suspend fun getStarWarsPeople(): PeopleList
}