package com.example.chewbaccaapp.data.repository

import com.example.chewbaccaapp.data.network.models.PeopleList
import kotlinx.coroutines.flow.Flow

interface StarWarsRepo {

     fun getStarWarsPeople(): Flow<PeopleList>

}