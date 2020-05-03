package com.example.assignmentshaadi.retrofit.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Coordinates(

    @SerializedName("latitude")
    @Expose
    private var latitude: String? = null,
    @SerializedName("longitude")
    @Expose
    private var longitude: String? = null
)