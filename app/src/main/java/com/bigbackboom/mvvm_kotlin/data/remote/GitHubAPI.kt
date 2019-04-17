package com.bigbackboom.mvvm_kotlin.data.remote

import com.bigbackboom.mvvm_kotlin.model.Repo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubAPI {

    /**
     * GitHubのユーザーのRepositoryを取得するAPI
     */
    @GET("users/{username}/repos")
    fun getUserRepository(@Path("username") username: String): Call<List<Repo>>
}