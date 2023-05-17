package com.example.todo

data class Task(var name: String,
                var category: TaskCategory,
                var isSelected:Boolean = false
)