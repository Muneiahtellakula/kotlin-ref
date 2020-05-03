package com.muneiah.caronaupdatenotify

import retrofit2.Response
import retrofit2.http.GET

interface Covid19IndiaApiService {
    @GET("/data.json")
    suspend fun getData(): Response<ApiResponse>

    companion object {
        const val BASE_URL = "https://api.covid19india.org/"
    }
}