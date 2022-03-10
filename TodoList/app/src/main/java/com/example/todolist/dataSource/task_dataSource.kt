package com.example.todolist.dataSource

import com.example.todolist.model.Task

object taskDataSource {
    private val list = arrayListOf<Task>()

    fun getList() = list

    fun insertTask(task: Task){
        list.add(task.copy(id = list.size+1))
    }
}