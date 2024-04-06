package com.example.todolistapp.model

import com.google.gson.annotations.SerializedName
data class Characteristics(
    val prey: String,

    @SerializedName("name_of_young")
    val nameOfYoung: String,

    @SerializedName("group_behavior")
    val groupBehavior: String,

    val diet: String,

    @SerializedName("number_of_species")
    val numberOfSpecies: Int,

    val color: String
)
