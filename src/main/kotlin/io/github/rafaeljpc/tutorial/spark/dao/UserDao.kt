package io.github.rafaeljpc.tutorial.spark.dao

import io.github.rafaeljpc.tutorial.spark.model.User
import java.util.concurrent.atomic.AtomicLong

class UserDao {
    private val users = hashMapOf(
        0L to User(id = 0, name = "Teste 0", email = "teste0@teste.com"),
        1L to User(id = 1, name = "Teste 1", email = "teste1@teste.com"),
        2L to User(id = 2, name = "Teste 2", email = "teste2@teste.com"),
        3L to User(id = 3, name = "Teste 3", email = "teste3@teste.com"),
        4L to User(id = 4, name = "Teste 4", email = "teste4@teste.com")
    )

    var lastId: AtomicLong = AtomicLong(users.size - 1L)

    fun save(name: String, email: String) {
        val id = lastId.incrementAndGet()
        users[id] = User(id = id, name = name, email = email)
    }

    fun findAll(): List<User> {
        return users.values.toList()
    }

    fun findById(id: Long): User? {
        return users[id]
    }

    fun findByEmail(email: String): User? {
        return users.values.find { it.email == email }
    }

    fun update(id: Long, name: String, email: String) {
        users[id] = User(id = id, name = name, email = email)
    }

    fun delete(id: Long) {
        users.remove(id)
    }

}