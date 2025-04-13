package com.example.chewbaccaapp.data.network

import com.example.chewbaccaapp.data.network.models.PeopleList
import kotlinx.coroutines.flow.Flow

interface StarWarsDataSource {

    fun getStarWarsPeople(): Flow<PeopleList>
}