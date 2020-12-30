package com.doruk.todolist.application.controller

import com.doruk.todolist.application.TodoService
import com.doruk.todolist.domain.Todo
import com.doruk.todolist.infrastructure.utils.JsonHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class TodoListControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc;

    @MockBean
    private lateinit var todoService: TodoService

    @Autowired
    private lateinit var jsonHelper: JsonHelper

    @Test
    fun getAllMethodShouldGetAllTodos() {

        val todo1 = Todo("GET UP")
        val todo2 = Todo("STAND UP")
        val todo3 = Todo("DONT GIVE UP TO FIGHT")

        BDDMockito.given(todoService.findAll()).willReturn(arrayListOf(todo1, todo2, todo3))

        mockMvc.perform(MockMvcRequestBuilders.get("/todo")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].todo").value("GET UP"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].todo").value("STAND UP"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].todo").value("DONT GIVE UP TO FIGHT"))
    }

    @Test
    fun shouldGetTodoById() {
        //Given
        val todo = Todo("SLEEP")

        BDDMockito.given(todoService.findById(1)).willReturn(todo)

        //When and Then
        mockMvc.perform(MockMvcRequestBuilders.get("/todo/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.todo").value("SLEEP"))
    }

    @Test
    fun shouldSaveTodoSuccessfully() {
        //Given
        val todo = Todo("WAKE UP")

        Mockito.`when`(todoService.saveTodo(todo)).thenReturn(todo)

        //When and Then
        mockMvc.perform(MockMvcRequestBuilders.post("/todo")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(jsonHelper.serializeToJson(todo)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated)
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.todo").value("WAKE UP"))
    }
}