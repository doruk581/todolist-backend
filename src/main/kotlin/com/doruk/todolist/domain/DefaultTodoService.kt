package com.doruk.todolist.domain

import com.doruk.todolist.application.TodoService
import com.doruk.todolist.infrastructure.TodoRepository
import org.springframework.stereotype.Service

@Service
class DefaultTodoService(var todoRepository: TodoRepository) : TodoService {

    override fun findAll(): MutableList<Todo> {
        return todoRepository.findAll()
    }

    override fun findById(id: Long): Todo {
        return todoRepository.findById(id).orElseThrow { throw TodoNotFoundException("Todo with id: $id not found") }
    }

    override fun saveTodo(todo: Todo): Todo {
        return todoRepository.save(todo)
    }

    override fun deleteById(id: Long) {
        todoRepository.deleteById(id)
    }
}