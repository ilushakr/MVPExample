package com.example.mvpexample.api

import com.google.gson.annotations.SerializedName

class PostResponse(
    @SerializedName("userId") val userId : Int,
    @SerializedName("id") val id : Int,
    @SerializedName("title") val title : String,
    @SerializedName("body") val body : String
)