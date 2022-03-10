package com.example.todolist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.databinding.ItemTaskBinding
import com.example.todolist.model.Task

class taskListAdapter : ListAdapter<Task,taskListAdapter.TaskViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTaskBinding.inflate(inflater, parent, false)
        return TaskViewHolder(binding)
    }
    override fun onBindViewholder(holder: TaskViewHolder, position: Int){
            holder.bind(getItem(position))
    }

    class TaskViewHolder(private val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind (item: Task?){
            binding.tvTitle.text = item.title
            binding.tvDate.text = "${item.date} ${item.hour}"
        }
    }
}
class Diffcalback