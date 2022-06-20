package com.norbersan.data.config

import com.mongodb.MongoClientSettings
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class Configuration {
    @Bean
    fun clientSettings(): MongoClientSettings? = null
}