package com.lina.healthmanager.handler

import com.lina.healthmanager.entity.VitalSignEntity
import com.lina.healthmanager.repository.VitalSignRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class VitalSignHandler(val repository: VitalSignRepository) {


    suspend fun add(userKey: String): String {
        return repository.save(VitalSignEntity(id = UUID.randomUUID().toString(), userKey = userKey)).id.toString()
    }
}