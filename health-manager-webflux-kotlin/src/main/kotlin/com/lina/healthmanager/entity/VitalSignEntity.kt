package com.lina.healthmanager.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate

@Table
class VitalSignEntity (
    @Id
    val id: String? = null,
    val userKey: String,
    val createdAt: LocalDate = LocalDate.now(),
    val deleted: Boolean = false
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as VitalSignEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int = id.hashCode()
}