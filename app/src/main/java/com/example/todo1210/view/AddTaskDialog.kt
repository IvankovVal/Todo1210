package com.example.todo1210.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.todo1210.R
import com.example.todo1210.model.ApiClient
import com.example.todo1210.viewmodel.TaskViewModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddTaskDialog : DialogFragment() {

    private lateinit var taskViewModel: TaskViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.add_dialog, container, false)
        val btnSave: Button = view.findViewById(R.id.btn_save)
        val btnCancel: Button = view.findViewById(R.id.btn_cancel)
        val etAddTask: EditText = view.findViewById(R.id.et_add_task)
        taskViewModel = ViewModelProvider(this)[TaskViewModel::class.java]

        //Кнопка выключения диалога
        btnCancel.setOnClickListener {
            dialog?.cancel()
        }
        //Кнопка "сохранить"
        btnSave.setOnClickListener {
            insertTask(name = etAddTask.text.toString(), status = false)
            dialog?.cancel()

        }


        return view
    }

    //----------Функция добавления задачи---------------------------------------------------------------
    private fun insertTask(name: String?, status: Boolean) {
        val callInsertTask: Call<ResponseBody?>? =
            ApiClient.instance?.api?.insertMyTask(name, status)
        callInsertTask?.enqueue(object : Callback<ResponseBody?> {    //здесь что-то не верно. Падает
            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
//нужно очистить список?

                taskViewModel.getAllTasks()
                (context as MainActivity).getTaskList()
//                Toast.makeText(context, "ЗАДАЧА ДОБАВЛЕНА", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                Toast.makeText(context, "ОШИБКА", Toast.LENGTH_SHORT).show()
            }
        })
    }
}