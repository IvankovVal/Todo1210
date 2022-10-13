package com.example.todo1210.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.example.todo1210.databinding.DetaileDialogBinding
import com.example.todo1210.model.TaskModel
import com.example.todo1210.viewmodel.ApiClient
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsDialog(var itemPosition: Int): BottomSheetDialogFragment() {

    private var binding:DetaileDialogBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DetaileDialogBinding.inflate(inflater,container,false)




        //положили в переменную конкретный пункт списка с которым будем работать
        //val task = model.allTasks.value!![itemPosition]


        binding?.etNametaskDetails?.setText("Задача")  //${task.name}

        //Кнопка выключения диалога
        binding?.btnCancel?.setOnClickListener {
            dialog?.cancel()
        }

        binding?.btnDelete?.setOnClickListener {

            deleteTask()
            dialog?.cancel()
        }

        binding?.btnEdit?.setOnClickListener {

            //в таск кладём id этого task и имя задачи из edittext
            //model.update_task(task = Task(task.id, binding?.etNametaskDetails?.text.toString(),task.status))

            editTask()
            dialog?.cancel()
        }


        return binding?.root
    }
//-------------------------функция удаления---------------------------------------------------------
    fun deleteTask() {
TODO()
//    val callDeleteTask: Call<ResponseBody?>? = ApiClient.instance?.api?.deleteMyTask(id)
//
//    callDeleteTask?.enqueue(object : Callback<ResponseBody?> {
//        override fun onResponse(call: Call<ResponseBody?>, response: Response<ResponseBody?>) {
//            Toast.makeText(
//                context,
//                "КАТЕГОРИЯ УДАЛЕНА",
//                Toast.LENGTH_SHORT
//            ).show()
//
//            loadCategories()
//        }
//
//
//        override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
//            Toast.makeText(
//                context,
//                "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//
//
//    })

}
//-------------------------функция редактирования---------------------------------------------------
    fun editTask() {
    TODO()
}
}