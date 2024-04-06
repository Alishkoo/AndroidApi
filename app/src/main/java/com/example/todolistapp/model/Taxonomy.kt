package com.example.todolistapp.model

import com.google.gson.annotations.SerializedName
data class Taxonomy(
    val kingdom: String,
    val order: String,
    val genus: String,

    @SerializedName("scientific_name")
    val scientificName: String
)
