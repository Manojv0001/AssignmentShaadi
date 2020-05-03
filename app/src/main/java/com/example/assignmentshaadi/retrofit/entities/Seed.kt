package com.example.assignmentshaadi.retrofit.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Seed(
    @SerializedName("seed")
    @Expose
    private var seed: String? = null,
    @SerializedName("results")
    @Expose
    private var results: Int? = null,
    @SerializedName("page")
    @Expose
    private var page: Int? = null,
    @SerializedName("version")
    @Expose
    private var version: String? = null
)