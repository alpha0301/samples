package com.example.reactordemo.repository;

import com.example.reactordemo.entity.MoneyDepositEvent;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyDepositRepository extends ReactiveCrudRepository<MoneyDepositEvent, Integer> {
}
