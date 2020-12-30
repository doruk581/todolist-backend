package com.doruk.todolist.domain

import com.doruk.todolist.infrastructure.TodoRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.util.*


@RunWith(MockitoJUnitRunner::class)
class DefaultTodoServiceTest {

    @InjectMocks
    private lateinit var todoService: DefaultTodoService

    @Mock
    private lateinit var todoRepository: TodoRepository

    @Test
    fun shouldGetAllTodos() {
        //Given
        val todo1 = Todo("FIRST TODO")
        val todo2 = Todo("SECOND TODO")
        val todo3 = Todo("THIRD TODO")

        Mockito.`when`(todoRepository.findAll()).thenReturn(arrayListOf(todo1, todo2, todo3))

        //When
        val todos = todoService.findAll()

        //Then
        Mockito.verify(todoRepository).findAll()

        assertThat(todos).isNotNull
        assertThat(todos).containsExactlyInAnyOrder(todo1, todo2, todo3)
    }

    @Test
    fun shouldGetTodoByTodoId() {
        //Given
        val todo = Todo("FIRST TODO")

        Mockito.`when`(todoRepository.findById(todo.id)).thenReturn(Optional.of(todo))

        //When
        val expectedTodo = todoService.findById(todo.id)

        //Then
        Mockito.verify(todoRepository).findById(todo.id)

        assertThat(expectedTodo).isNotNull
    }
}