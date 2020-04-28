package com.muneiah.retrofitgithub

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/*
interface GitHubServices {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<Repo>>
}*/
interface GitHubServices
{
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user:String): Call<List<Repo>>
}