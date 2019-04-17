package com.bigbackboom.mvvm_kotlin.model

import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("full_name")
    val fullName: String
)