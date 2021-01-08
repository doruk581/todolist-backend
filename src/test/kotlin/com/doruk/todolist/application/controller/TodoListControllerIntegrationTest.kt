package com.doruk.todolist.application.controller

import com.doruk.todolist.domain.Todo
import org.assertj.core.api.Assertions.assertThat
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoListControllerIntegrationTest {

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @Test
    fun getTodoByIdReturnCorrectTodo() {

        var id = 1L

        val todoResponse: ResponseEntity<Todo> = restTemplate.getForEntity(url = "/todo/" + id, uriVariables =
        Todo::class)

        assertThat(todoResponse).isNotNull
        assertThat(todoResponse.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(todoResponse.body?.todo).isEqualTo("DENEME")
    }

    @Test
    @Ignore
    fun getAllShouldGetAllTodos() {

        val todoResponse: ResponseEntity<MutableList<Todo>> = restTemplate.exchange("/todo", HttpMethod.GET,
                HttpEntity.EMPTY, object : ParameterizedTypeReference<MutableList<Todo>>() {})

        assertThat(todoResponse).isNotNull
        assertThat(todoResponse.body?.get(0)?.id).isEqualTo(1L)
        assertThat(todoResponse.body?.get(1)?.id).isEqualTo(2L)
        assertThat(todoResponse.body?.get(1)?.todo).isEqualTo("DENEME2")
    }

    @Test
    fun saveTodoShouldSaveTodoEntityAndReturn() {

        //Given
        val todo = Todo("TDD EPEY YORUCU")

        //When
        val todoResponse = restTemplate.postForEntity("/todo", todo, Todo::class.java)

        //Then
        assertThat(todoResponse).isNotNull
        assertThat(todoResponse.statusCode).isEqualTo(HttpStatus.CREATED)
        assertThat(todoResponse.body?.todo).isEqualTo("TDD EPEY YORUCU")
    }
}