package com.example.repository

import com.example.model.Priority
import com.example.model.Task

object TaskRepository {
    private val tasks = mutableListOf(
        Task("cleaning", "remove all connections, Power -- back to me!", Priority.LOW),
        Task("reading", "Read Manifest-Nirvana article, then correct to publish it", Priority.HIGH),
        Task("planning", "Assume the general line images of next Lunar Cycle", Priority.HIGH),
        Task("researching", "Dive in hexagram level descriptions of number 44", Priority.LOW),
        Task("meditating", "Attend meditation 18-19", Priority.VITAL),
        Task("reflecting", "Remember what is happening this Lunar Cycle", Priority.HIGH),
    )

    fun allTasks() = tasks

    fun tasksByPriority(priority: Priority): List<Task> =
        tasks.filter { it.priority == priority }


    fun taskByName(taskName: String): Task? =
        tasks.find { it.name.equals(taskName, ignoreCase = true) }


    fun addTask(task: Task) {
        if (taskByName(task.name) != null) {
            throw IllegalStateException("Task with specified name already exist")
        }
        tasks.add(task)
    }

    fun deleteTask(taskName: String): Boolean {
        return tasks.removeIf { it.name.equals(taskName, ignoreCase = true) }
    }
}