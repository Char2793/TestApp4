package com.example.chewbaccaapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chewbaccaapp.data.network.models.PeopleData
import com.example.chewbaccaapp.data.network.models.PeopleList
import com.example.chewbaccaapp.data.repository.StarWarsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarWarsViewModel @Inject constructor(
    val starWarsRepo: StarWarsRepo
): ViewModel() {

    private val _peopleList: MutableStateFlow<List<PeopleData>> = MutableStateFlow(listOf())
    val peopleList = _peopleList.asStateFlow()

    fun getPeopleData() {
        viewModelScope.launch {
            starWarsRepo.getStarWarsPeople().collect {
                _peopleList.value = it.results
            }
        }
    }

}