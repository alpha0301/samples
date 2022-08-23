package com.example.reactordemo.handler;

import com.example.reactordemo.dto.DepositRequest;
import com.example.reactordemo.entity.Account;
import com.example.reactordemo.entity.MoneyDepositEvent;
import com.example.reactordemo.repository.AccountRepository;
import com.example.reactordemo.repository.MoneyDepositRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Component
public class GetBankHandler {
    private final AccountRepository accountRepository;
    private final MoneyDepositRepository moneyDepositRepository;

    private final TransactionalOperator operator;

//    @Transactional
    public Mono<Account> deposit(DepositRequest request) {
        return accountRepository.findById(request.getAccount())
                .doOnNext(acc -> acc.setBalance(acc.getBalance() + request.getAmount()))
                .flatMap(accountRepository::save)
                .thenReturn(toEvent(request))
                .flatMap(moneyDepositRepository::save)
                .as(operator::transactional)
                .then(accountRepository.findById(request.getAccount()));
    }

    private MoneyDepositEvent toEvent(DepositRequest request) {
        return MoneyDepositEvent.create(
                null,
                request.getAccount(),
                request.getAmount()
        );
    }
}
