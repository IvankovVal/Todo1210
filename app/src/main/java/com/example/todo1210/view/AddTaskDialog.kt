package com.example.todo1210.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.todo1210.R
import com.example.todo1210.viewmodel.ApiClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddTaskDialog : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.add_dialog, container, false)
        val btn_save: Button = view.findViewById(R.id.btn_save)
        val btn_cancel: Button = view.findViewById(R.id.btn_cancel)
        val et_add_task: EditText = view.findViewById(R.id.et_add_task)

        //Кнопка выключения диалога
        btn_cancel.setOnClickListener {
            dialog?.cancel()
        }
        //Кнопка "сохранить"
        btn_save.setOnClickListener {
            insertTask(name = et_add_task.text.toString(), status = false)
            dialog?.cancel()

        }


        return view
    }

    //----------Функция добавления задачи---------------------------------------------------------------
    fun insertTask(name: String?, status: Boolean) {
        val callInsertTask: Call<ResponseBody?>? =
            ApiClient.instance?.api?.insertMyTask(name, status)
        callInsertTask?.enqueue(object : Callback<ResponseBody?> {    //здесь что-то не верно. Падает
            override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
                Toast.makeText(context, "ЗАДАЧА ДОБАВЛЕНА", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                Toast.makeText(context, "ОШИБКА", Toast.LENGTH_SHORT).show()
            }
        })
    }
}