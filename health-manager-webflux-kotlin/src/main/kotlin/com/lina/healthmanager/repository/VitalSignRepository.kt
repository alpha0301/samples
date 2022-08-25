package com.lina.healthmanager.repository

import com.lina.healthmanager.entity.VitalSignEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface VitalSignRepository : CoroutineCrudRepository<VitalSignEntity, String> {
}