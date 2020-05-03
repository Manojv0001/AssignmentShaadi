package com.example.assignmentshaadi.retrofit.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResultDTO(
    @SerializedName("results")
    @Expose
    var results: ArrayList<Result>? = null
)

