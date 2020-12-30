package com.doruk.todolist.application.controller

import com.doruk.todolist.application.TodoService
import com.doruk.todolist.domain.Todo
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todo")
class TodoController(var todoService: TodoService) {

    @GetMapping("{id}")
    fun findTodoById(@PathVariable(value = "id") id: Long): Todo = this.todoService.findById(id)

    @GetMapping
    fun getAllTodos(): MutableList<Todo> = this.todoService.findAll()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveTodo(@RequestBody todo: Todo): Todo {
        return todoService.saveTodo(todo)
    }

    @DeleteMapping("{id}")
    fun deleteById(@PathVariable(value = "id") id: Long) {
        todoService.deleteById(id)
    }
}