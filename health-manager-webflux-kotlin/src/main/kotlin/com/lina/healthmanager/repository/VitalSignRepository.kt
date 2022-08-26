package com.lina.healthmanager.repository

import com.lina.healthmanager.entity.VitalSignEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@Repository
interface VitalSignRepository : CoroutineCrudRepository<VitalSignEntity, String> {

    suspend fun findByUserKeyAndCreatedAtAfterOrderByCreatedAtDesc(userKey: String, startDateTime: LocalDateTime): VitalSignEntity
    fun findFirstByUserKeyOrderByCreatedAtDesc(userKey: String): Mono<VitalSignEntity>
    fun deleteByUserKey(userKey: String)
}