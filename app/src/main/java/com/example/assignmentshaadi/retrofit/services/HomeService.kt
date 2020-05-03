package com.example.assignmentshaadi.retrofit.services

import com.example.assignmentshaadi.retrofit.entities.ResultDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeService{

    @GET("/api/")
    fun getResults(@Query("results") size : Int) : Single<ResultDTO>
}