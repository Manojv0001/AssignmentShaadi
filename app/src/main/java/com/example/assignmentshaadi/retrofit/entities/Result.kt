package com.example.assignmentshaadi.retrofit.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Result(

    @SerializedName("name")
    @Expose
    var name: Name? = null,
    @SerializedName("email")
    @Expose
    var email: String? = null,
    @SerializedName("picture")
    @Expose
    var picture: Picture? = null
)