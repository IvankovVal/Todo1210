package com.example.todo1210.viewmodel

import com.example.todo1210.model.TaskModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
//Добавление задачи
    @FormUrlEncoded
    @POST("insertTask.php")
    fun insertMyTask(
        @Field("name") name: String?,
        @Field("status") status: Boolean?
        ): Call<ResponseBody?>?


//Редактирование задачи
    @FormUrlEncoded
    @POST("updateTask.php")
    fun updateMyTask(
        @Field("id") id: Int,
        @Field("name") name: String?,
        @Field("status") status: Boolean?
    ): Call<ResponseBody?>?

//Удаление задачи
    @FormUrlEncoded
    @POST("deleteTask.php")
    fun deleteMyTask(
        @Field("id") id: Int
    ): Call<ResponseBody?>?


//Запрос списка "все"
    @GET("getAllTasks.php")
    fun getAllMyTask(): Call<ArrayList<TaskModel>>
//Запрос списка "готово"
    @GET("getMyCompliteTask.php")
    fun getMyCompliteTask(): Call<ArrayList<TaskModel>>
//Запрос списка "в работе"
    @GET("getActiveTask.php")
    fun getMyActiveTask(): Call<ArrayList<TaskModel>>

}