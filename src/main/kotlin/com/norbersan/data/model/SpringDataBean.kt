package com.norbersan.data.model

import org.springframework.data.annotation.Id
import java.time.LocalDateTime

data class SpringDataBean(
    @Id
    val id: String,
    val intNumber: Int,
    val doubleNumber: Double,
    val date: LocalDateTime
)