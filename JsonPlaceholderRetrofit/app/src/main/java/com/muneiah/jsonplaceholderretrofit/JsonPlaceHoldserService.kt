package com.muneiah.jsonplaceholderretrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface JsonPlaceHoldserService {
    @GET("posts")
  //  fun getAllValues(): Call<List<Post>>
    suspend fun getAllValues(): Response<List<Post>>
    @POST("posts")
    //fun postValue(@Body post: Post):Call<Post>//body of the post data auto generated data at url using
   suspend fun postValue(@Body post: Post):Response<Post>//body of the post data auto generated data at url using

}