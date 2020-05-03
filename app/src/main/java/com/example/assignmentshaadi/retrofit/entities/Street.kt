package com.example.assignmentshaadi.retrofit.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Street(

    @SerializedName("number")
    @Expose
    private var number: Int? = null,
    @SerializedName("name")
    @Expose
    private var name: String? = null
)