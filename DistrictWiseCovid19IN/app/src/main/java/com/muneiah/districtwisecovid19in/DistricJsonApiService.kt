package com.muneiah.districtwisecovid19in

import retrofit2.Response
import retrofit2.http.GET

interface DistricJsonApiService
{
    @GET("/districts_daily.json")
    suspend fun getData(): Response<Post>

    /*companion object {
        const val BASE_URL = "https://api.covid19india.org/"
    }*/
}