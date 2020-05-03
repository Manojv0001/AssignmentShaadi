package com.example.assignmentshaadi.retrofit.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Timezone(

    @SerializedName("offset")
    @Expose
    private var offset: String? = null,
    @SerializedName("description")
    @Expose
    private var description: String? = null

)