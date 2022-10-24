package com.example.todo1210.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo1210.model.ApiClient
import com.example.todo1210.model.ApiInterface
import com.example.todo1210.model.TaskModel
import com.example.todo1210.view.RecyclerViewAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskViewModel : ViewModel() {


    val tasksList: MutableLiveData<TaskModel> by lazy {
        MutableLiveData<TaskModel>()
    }

    init {
//        tasksList.value = ApiClient.instance?.api?.getAllMyTask()
//        tasksList?.enqueue(object : Callback<ArrayList<TaskModel>>)
    }
    fun getAllTasks() {

        val callTasks = ApiClient.instance?.api?.getAllMyTask()
        callTasks?.enqueue(object : Callback<ArrayList<TaskModel>> {
            override fun onResponse(
                call: Call<ArrayList<TaskModel>>,
                response: Response<ArrayList<TaskModel>>
            ) {
//-------------переменная со списком
                val loadTasks = response.body()


            }

            override fun onFailure(call: Call<ArrayList<TaskModel>>, t: Throwable) {
                TODO()
                //Toast.makeText( this@TaskViewModel, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()

            }
        })

    }

    fun insertTask(){
        TODO()
        //tasksList.value = (tasksList.value)?.plus(1)
    }
    fun updateTask(){
        TODO()
        //tasksList.value = (tasksList.value)?.plus(1)
    }
    fun deleteTask(){
        TODO()
        //tasksList.value = (tasksList.value)?.plus(1)
    }
}