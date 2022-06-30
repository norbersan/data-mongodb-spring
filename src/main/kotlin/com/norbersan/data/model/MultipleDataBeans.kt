package com.norbersan.data.repository

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import java.time.LocalDateTime

data class FullDataBean(
    @Id
    val id: String,
    val commonIntNumber: Int,
    val commonDoubleNumber: Double,
    val commonDate: LocalDateTime,
    val intNumber1: Int? = null,
    val intNumber2: Int? = null,
    val intNumber3: Int? = null,
    val doubleNumber1: Double? = null,
    val doubleNumber2: Double? = null,
    val doubleNumber3: Double? = null,
    val date1: LocalDateTime? = null,
    val date2: LocalDateTime? = null,
    val date3: LocalDateTime? = null
)

data class SafeFullDataBean(
    @Id
    val id: String,
    val commonIntNumber: Int,
    val commonDoubleNumber: Double,
    val commonDate: LocalDateTime
)

data class PartialDataBean1(
    @Id
    val id: String,
    val intNumber1: Int,
    val doubleNumber1: Double,
    val date1: LocalDateTime
)

data class PartialDataBean2(
    @Id
    val id: String,
    val intNumber2: Int,
    val doubleNumber2: Double,
    val date2: LocalDateTime
)

data class PartialDataBean3(
    @Id
    val id: String,
    val intNumber3: Int,
    val doubleNumber3: Double,
    val date3: LocalDateTime
)