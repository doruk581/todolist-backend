package com.doruk.todolist.application.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SwaggerController {
    @GetMapping("/")
    fun redirectToSwaggerUi(): String {
        return "redirect:/swagger-ui.html"
    }
}