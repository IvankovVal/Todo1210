package com.example.todo1210.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo1210.R
import com.example.todo1210.viewmodel.ApiClient
import com.example.todo1210.model.TaskModel
import com.example.todo1210.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.OnItemClickListener {

    private var binding: ActivityMainBinding? = null
    private var recyclerViewAdapter: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

//---------- Кнопка добавления задания_________________
        val btn: Button = findViewById(R.id.btn)
        btn.setOnClickListener {
            val add_dialog = AddTaskDialog()
            val manager = supportFragmentManager
            add_dialog.show(manager, "add_dialog")
        }
        //---------- Радио группа---------------------------------------------------------------------------
        val rb_group: RadioGroup = findViewById(R.id.fild_for_btns)
        var checkedRbtn: Int = rb_group.checkedRadioButtonId
        rb_group.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.btn_all -> getAllTasks()
                R.id.btn_complete -> getActiveTasks()
                R.id.btn_active -> getCompleteTasks()
            }
        }


    }
    //---------- Конец функции onCreate-------------------------------------------------------------

    //---------- Клик по пункту списка-----------------------------------------------------------------
    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Пункт $position нажат", Toast.LENGTH_LONG).show()
        val ditaile_dialog = DetailsDialog(position)
        val manager = supportFragmentManager
        ditaile_dialog.show(manager, "add_dialog")
    }

    //---------- Чек-бокс в пункте списка-----------------------------------------------------------------
    override fun onCheckBoxClick(taskModel: TaskModel, isChecked: Boolean) {
        //model.onTaskCheckedChange(taskModel, isChecked)
    }

    //---------- Получение всего списка--------------------------------------------------------------
    fun getAllTasks() {

        val callTasks = ApiClient.instance?.api?.getAllMyTask()
        callTasks?.enqueue(object : Callback<ArrayList<TaskModel>> {
            override fun onResponse(
                call: Call<ArrayList<TaskModel>>,
                response: Response<ArrayList<TaskModel>>
            ) {
//-------------переменная со списком
                val loadTasks = response.body()

                binding?.recyclerView?.layoutManager = LinearLayoutManager(this@MainActivity)

                binding?.recyclerView?.adapter = loadTasks?.let { RecyclerViewAdapter(it,this@MainActivity) }

                // binding?.recyclerView?.adapter = recyclerViewAdapter

                Toast.makeText(this@MainActivity, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()


            }

            override fun onFailure(call: Call<ArrayList<TaskModel>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()

            }
        })

    }

    //---------- Получение списка "В работе"--------------------------------------------------------------
    fun getActiveTasks() {

        val callActiveTasks = ApiClient.instance?.api?.getMyActiveTask()
        callActiveTasks?.enqueue(object : Callback<ArrayList<TaskModel>> {
            override fun onResponse(
                call: Call<ArrayList<TaskModel>>,
                response: Response<ArrayList<TaskModel>>
            ) {
//-------------переменная со списком
                val loadTasks = response.body()

                binding?.recyclerView?.layoutManager = LinearLayoutManager(this@MainActivity)

                binding?.recyclerView?.adapter = loadTasks?.let { RecyclerViewAdapter(it,this@MainActivity) }

                // binding?.recyclerView?.adapter = recyclerViewAdapter

                Toast.makeText(this@MainActivity, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()


            }

            override fun onFailure(call: Call<ArrayList<TaskModel>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()

            }
        })

    }

    //---------- Получение списка "Готово"--------------------------------------------------------------
    fun getCompleteTasks() {

        val callActiveTasks = ApiClient.instance?.api?.getMyCompliteTask()
        callActiveTasks?.enqueue(object : Callback<ArrayList<TaskModel>> {
            override fun onResponse(
                call: Call<ArrayList<TaskModel>>,
                response: Response<ArrayList<TaskModel>>
            ) {
//-------------переменная со списком
                val loadTasks = response.body()

                binding?.recyclerView?.layoutManager = LinearLayoutManager(this@MainActivity)

                binding?.recyclerView?.adapter = loadTasks?.let { RecyclerViewAdapter(it,this@MainActivity) }

                // binding?.recyclerView?.adapter = recyclerViewAdapter

                Toast.makeText(this@MainActivity, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()


            }

            override fun onFailure(call: Call<ArrayList<TaskModel>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()

            }
        })

    }

}