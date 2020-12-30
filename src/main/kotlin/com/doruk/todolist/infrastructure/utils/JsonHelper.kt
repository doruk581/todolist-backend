package com.doruk.todolist.infrastructure.utils

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component

@Component
class JsonHelper {
    @Throws(JsonProcessingException::class)
    fun serializeToJson(request: Any?): String {
        val objectMapper = ObjectMapper()
        return objectMapper.writeValueAsString(request)
    }
}