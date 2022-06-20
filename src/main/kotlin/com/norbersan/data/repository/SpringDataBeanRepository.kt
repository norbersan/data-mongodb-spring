package com.norbersan.data.repository

import com.norbersan.data.model.SpringDataBean
import org.springframework.data.mongodb.repository.MongoRepository

interface SpringDataBeanRepository: MongoRepository<SpringDataBean, String> {
}