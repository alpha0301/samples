package com.lina.healthmanager.entity

import java.time.LocalDate

class VitalSignCompositeKey(
    val userKey: String,
    val createdDate: LocalDate
)