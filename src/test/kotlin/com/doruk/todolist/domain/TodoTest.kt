package com.doruk.todolist.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TodoTest {

    @Test
    fun controlThatConstructorWorksCorrectly() {
        val todo = Todo("IT IS WORK!")

        assertThat(todo.todo).isEqualTo("IT IS WORK!")
    }

    @Test
    fun controlThatWhenNoParametersProvidedThenDefaultParameterIsEmptyString() {
        val todo = Todo()

        assertThat(todo.todo).isNotNull()
        assertThat(todo.todo).isEqualTo("")
    }
}