package com.example.assignmentshaadi.retrofit.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("uuid")
    @Expose
    private var uuid: String? = null,
    @SerializedName("username")
    @Expose
    private var username: String? = null,
    @SerializedName("password")
    @Expose
    private var password: String? = null,
    @SerializedName("salt")
    @Expose
    private var salt: String? = null,
    @SerializedName("md5")
    @Expose
    private var md5: String? = null,
    @SerializedName("sha1")
    @Expose
    private var sha1: String? = null,
    @SerializedName("sha256")
    @Expose
    private var sha256: String? = null

)