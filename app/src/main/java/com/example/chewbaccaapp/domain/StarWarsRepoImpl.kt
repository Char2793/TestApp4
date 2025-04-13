package com.example.chewbaccaapp.domain

import com.example.chewbaccaapp.data.network.StarWarsApi
import com.example.chewbaccaapp.data.network.StarWarsDataSource
import com.example.chewbaccaapp.data.network.models.PeopleList
import com.example.chewbaccaapp.data.repository.StarWarsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StarWarsRepoImpl @Inject constructor(
    private val dataSource: StarWarsDataSource
): StarWarsRepo {
    override fun getStarWarsPeople(): Flow<PeopleList> {
       return dataSource.getStarWarsPeople()
    }
}