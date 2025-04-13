package com.example.chewbaccaapp.data.network.models

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class PeopleList(

    @SerializedName("results")
    val results: List<PeopleData>

)

data class PeopleData(
    @SerializedName("name")
    val name: String
)
