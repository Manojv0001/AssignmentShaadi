package com.example.assignmentshaadi.retrofit.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Location(

    @SerializedName("street")
    @Expose
    private var street: Street? = null,
    @SerializedName("city")
    @Expose
    private var city: String? = null,
    @SerializedName("state")
    @Expose
    private var state: String? = null,
    @SerializedName("country")
    @Expose
    private var country: String? = null,
    @SerializedName("postcode")
    @Expose
    private var postcode: Int? = null,
    @SerializedName("coordinates")
    @Expose
    private var coordinates: Coordinates? = null,
    @SerializedName("timezone")
    @Expose
    private var timezone: Timezone? = null
)