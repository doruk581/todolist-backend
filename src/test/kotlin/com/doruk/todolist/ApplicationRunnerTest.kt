package com.doruk.todolist

import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
class ApplicationRunnerTest {

    @Test
    @Ignore
    fun applicationShouldRunSuccessfully() = KotlinMain.main(arrayOf("test"));
}