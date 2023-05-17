package com.example.todo

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.ItemTaskBinding

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemTaskBinding.bind(view)

    fun render(task: Task){
        if(task.isSelected){
            binding.tvTask.paintFlags = binding.tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }else{
            binding.tvTask.paintFlags = binding.tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        binding.cbTask.isChecked = task.isSelected
        binding.tvTask.text = task.name

        val color = when(task.category){
            TaskCategory.Business -> R.color.business_category
            TaskCategory.Other -> R.color.other_category
            TaskCategory.Personal -> R.color.personal_category
        }

        binding.cbTask.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(binding.tvTask.context, color)
        )
    }
}