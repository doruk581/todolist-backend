package com.doruk.todolist.infrastructure.repository

import com.doruk.todolist.domain.Todo
import com.doruk.todolist.infrastructure.TodoRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@DataJpaTest
class TodoRepositoryTest {

    @Autowired
    private lateinit var testEntityManager: TestEntityManager

    @Autowired
    private lateinit var todoRepository: TodoRepository

    @Test
    fun shouldFindTodoByTodoId() {

        val todo = Todo("TRY THIS")
        val id = testEntityManager.persistAndGetId(todo)

        val optionalTodo = todoRepository.findById(id as Long)

        assertThat(optionalTodo).isPresent
        val expectedTodo = optionalTodo.get()
        assertThat(expectedTodo.id).isNotNull()
        assertThat(expectedTodo.todo).isEqualTo("TRY THIS")
    }
}