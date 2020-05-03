package com.example.assignmentshaadi.retrofit.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Registered(

    @SerializedName("date")
    @Expose
    private var date: String? = null,
    @SerializedName("age")
    @Expose
    private var age: Int? = null
)