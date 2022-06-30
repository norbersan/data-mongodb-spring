package com.norbersan

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class DataSpringApplication

fun main(args: Array<String>) {
    runApplication<DataSpringApplication>(*args)
}
