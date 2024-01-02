package com.youngseo3.lacuna.myapplication.data.remote

import com.google.gson.annotations.SerializedName

data class BoardWriteResponse(
    @SerializedName(value = "time") val time: String,
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = " result") val result: Result
    )

data class Result(
    @SerializedName(value = "boardId") var boardId: Int,
    @SerializedName(value = "createdAt") val createdAt: String,
)