package io.github.rafaeljpc.tutorial.spark

import io.github.rafaeljpc.tutorial.spark.dao.UserDao
import spark.Request
import spark.Spark.*

fun main(args: Array<String>) {
    val userDao = UserDao()

    path("/users") {
        get("") { req, res ->
            res.type("application/json")
            userDao.findAll()
        }

        get("/:id") { req, res ->
            res.type("application/json")
            userDao.findById(req.params("id").toLong())
        }

        get("/email/:email") { req, res ->
            res.type("application/json")
            userDao.findByEmail(req.params("email"))
        }

        post("") { req, res ->
            res.type("application/json")
            userDao.save(name = req.qp("name"), email = req.qp("email"))
            res.status(201)
            "ok"
        }

        patch("/:id") { req, res ->
            res.type("application/json")
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