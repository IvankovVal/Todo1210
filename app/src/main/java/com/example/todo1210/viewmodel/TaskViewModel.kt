package com.example.todo1210.viewmodel


import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo1210.model.ApiClient
import com.example.todo1210.model.TaskModel
import com.example.todo1210.view.RecyclerViewAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TaskViewModel : ViewModel() {


    val tasksList: MutableLiveData<ArrayList<TaskModel>> by lazy {MutableLiveData<ArrayList<TaskModel>>()}

    init {
        getAllTasks()
    }


        fun getAllTasks() {

            val callActiveTasks = ApiClient.instance?.api?.getAllMyTask()
            callActiveTasks?.enqueue(object : Callback<ArrayList<TaskModel>> {
                override fun onResponse(
                    call: Call<ArrayList<TaskModel>>,
                    response: Response<ArrayList<TaskModel>>
                ) {
//-------------переменная со списком
                    val loadTasks = response.body()
                    tasksList.postValue(loadTasks)



                }

                override fun onFailure(call: Call<ArrayList<TaskModel>>, t: Throwable) {
                   // Toast.makeText(this@MainActivity, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()

                }
            })

        }
//--------------------------------------------------------------------------------------------------
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



