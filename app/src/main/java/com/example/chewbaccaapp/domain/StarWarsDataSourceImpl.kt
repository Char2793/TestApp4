package com.example.chewbaccaapp.domain

import com.example.chewbaccaapp.data.network.StarWarsApi
import com.example.chewbaccaapp.data.network.StarWarsDataSource
import com.example.chewbaccaapp.data.network.models.PeopleList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StarWarsDataSourceImpl @Inject constructor(val api: StarWarsApi): StarWarsDataSource {
    override fun getStarWarsPeople(): Flow<PeopleList> {
        return flow {
           val response =  api.getStarWarsPeople()
            emit(response)
        }

    }
}