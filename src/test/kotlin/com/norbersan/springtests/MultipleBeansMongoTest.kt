package com.norbersan.springtests

import com.norbersan.data.repository.*
import org.bson.types.ObjectId
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

@SpringBootTest
class MultipleBeansMongoTest {
    @Autowired
    lateinit var repository: FullDataBeanRepository

    @Test
    fun test(){
        val id = ObjectId().toString()

        val fullDataBean1 = FullDataBean(id, 123, 1.1, LocalDateTime.parse("1975-01-01T00:00"))

        repository.save(fullDataBean1)

        repository.updateCommonIntNumberById(id, 12)

        val safeFullDataBean = repository.findById(id.toString()).get()

/*
        val partial1 = PartialDataBean1(id, 1, 1.1, LocalDateTime.parse("1900-01-01T00:00"))
        repository.updatePartialDataBean1(partial1)

        val partial2 = PartialDataBean2(id, 2, 1.2, LocalDateTime.parse("1999-12-31T00:00"))
        repository.updatePartialDataBean2(partial2)

        val partial3 = PartialDataBean3(id, 3, 1.3, LocalDateTime.parse("2055-01-01T00:00"))
        repository.updatePartialDataBean3(partial3)

        val safeFullDataBean2 = repository.findById(id).get()
        val fullDataBean2 = repository.findById(id).get()
*/
    }
}