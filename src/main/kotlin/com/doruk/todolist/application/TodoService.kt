package com.doruk.todolist.application

import com.doruk.todolist.domain.Todo

interface TodoService {

    fun findAll(): MutableList<Todo>

    fun findById(id: Long): Todo

    fun saveTodo(todo: Todo): Todo

    fun deleteById(id: Long)
}