package com.example

import com.example.model.Task
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertContentEquals

class ApplicationTest {

    @Test
    fun tasksCanBeFoundByPriority() = testApplication {
        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }

        val response = client.get("/tasks/byPriority/HIGH")
        val tasks = response.body<List<Task>>()

        val expectedNames = listOf("reflecting", "planning", "reading")
        val actualNames = tasks.map { it.name }
        assertContentEquals(expectedNames, actualNames)
    }
}
