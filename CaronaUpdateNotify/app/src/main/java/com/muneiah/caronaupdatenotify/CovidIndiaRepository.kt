package com.muneiah.caronaupdatenotify


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

@ExperimentalCoroutinesApi
class CovidIndiaRepository(private val apiService: Covid19IndiaApiService) {

    fun getData(): Flow<State<ApiResponse>> {
        return object : NetworkBoundRepository<ApiResponse>() {
            override suspend fun fetchFromRemote(): Response<ApiResponse> = apiService.getData()
        }.asFlow().flowOn(Dispatchers.IO)
    }
}