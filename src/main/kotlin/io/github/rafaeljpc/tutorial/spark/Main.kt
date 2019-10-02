package io.github.rafaeljpc.tutorial.spark

import io.github.rafaeljpc.tutorial.spark.dao.UserDao
import spark.Request
import spark.Spark.*

fun main(args: Array<String>) {
    val userDao = UserDao()

    path("/users") {
        get("") { req, resp -> userDao.findAll() }

        get("/:id") { req, resp -> userDao.findById(req.params("id").toLong()) }

        get("/email/:email") { req, resp -> userDao.findByEmail(req.params("email")) }

        post("") { req, resp ->
            userDao.save(name = req.qp("name"), email = req.qp("email"))
            resp.status(201)
            "ok"
        }

        patch("/:id") { req, resp ->
            userDao.update(
                id = req.params("id").toLong(),
                name = req.qp("name"),
                email = req.qp("email")
            )
            "ok"
        }

        delete("/:id") { req, res -> userDao.delete(req.params("id").toLong()) }
    }
}

fun Request.qp(key: String): String = this.queryParams(key)