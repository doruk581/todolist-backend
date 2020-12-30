package com.doruk.todolist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

object KotlinMain {
    @JvmStatic
    fun main(args: Array<String>) {
        runApplication<Application>(*args)
    }
}