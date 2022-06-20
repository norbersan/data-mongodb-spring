package com.norbersan.data.model

import java.time.LocalDateTime

data class SpringDataBean(
    val id :String,
    val intNumber: Int,
    val doubleNumber: Double,
    val date: LocalDateTime
)