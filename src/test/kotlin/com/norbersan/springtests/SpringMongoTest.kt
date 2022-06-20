package com.norbersan.springtests

import com.norbersan.data.model.SpringDataBean
import com.norbersan.data.repository.SpringDataBeanRepository
import org.bson.types.ObjectId
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class SpringMongoTest {
    @Autowired
    lateinit var repository: SpringDataBeanRepository

    @Test
    fun `basic CRUD operations`(){
        val bean = SpringDataBean(
            id= ObjectId().toString(),
            intNumber = 12,
            doubleNumber = 12.3,
            date = LocalDateTime.now())

        repository.save(bean)

        val beanList = repository.findAll()
    }
}