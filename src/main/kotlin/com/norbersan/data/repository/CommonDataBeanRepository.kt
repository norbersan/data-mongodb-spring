package com.norbersan.data.repository

import com.norbersan.data.model.CommonDataBean
import org.springframework.data.repository.CrudRepository


interface CommonDataBeanRepository: CrudRepository<CommonDataBean, String> {
}