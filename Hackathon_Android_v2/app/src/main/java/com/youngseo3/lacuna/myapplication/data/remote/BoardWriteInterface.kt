package com.youngseo3.lacuna.myapplication.data.remote

import com.youngseo3.lacuna.myapplication.data.entities.BoardWrite
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface BoardWriteInterface {
    @POST("api/boards/")
    fun boardWrite(@Body board: BoardWrite): Call<BoardWriteResponse>
}