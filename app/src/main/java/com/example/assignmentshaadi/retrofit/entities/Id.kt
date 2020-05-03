package com.example.assignmentshaadi.retrofit.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Id (

    @SerializedName("name")
    @Expose
    private var name: String? = null,
    @SerializedName("value")
    @Expose
    private var value: String? = null
)