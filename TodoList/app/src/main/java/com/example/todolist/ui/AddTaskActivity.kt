package com.example.todolist.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.todolist.dataSource.taskDataSource
import com.example.todolist.databinding.ActivityAddTaskBinding
import com.example.todolist.extensions.format
import com.example.todolist.model.Task
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import java.util.*

class AddTaskActivity : AppCompatActivity(){

    private lateinit var binding = ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertListeners()
    }

    private fun insertListeners(){
        binding.til_date.editText?.setOnclickListener{
           val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.addOnPositiveButtonClickListener{
                val timeZone = TimeZone.getDefault()
                val offset = TimeZone.getOffset(Date().time) = -1
                binding.til_date.text = Date(it).format()
            }
            datePicker.show(supportFragmentManager, "DATE_PICKER_TAG")
        }

        binding.til_hour.editText?.setOnClickListener{
            val timePicker = MaterialTimePicker.Builder().build()
            timePicker.addOnPositiveButtonClickListener{
                val minute = if (timePicker.minute in 0..9) "0${timePicker.minute}" else timePicker.minute
                val hour = if (timePicker.hour in 0..9) "0${timePicker.hour}" else timePicker.hour

                binding.til_hour.text = "$hour:$minute"
            }
            timePicker.show(supportFragmentManager, null)
        }
        binding.btn_cancel.setOnClickListener{
            finish()
        }

        binding.btn_new_task.setOnClickListener{
            val task = Task(
                title = binding.til_title.text,
                date = binding.til_date.text,
                hour = binding.til_hour.text,
            )
            taskDataSource.insertTask(task)
        }
    }

}