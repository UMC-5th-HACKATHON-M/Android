package com.youngseo3.lacuna.myapplication.data.entities

import retrofit2.http.Field

data class BoardWrite (
    @Field("topic") var topic : String,
    @Field("title") var title : String,
    @Field("content") var content : String
    )