package com.santiagoposadag.cs50.receiverconsumer.repository;

import com.santiagoposadag.cs50.receiverconsumer.collections.CryptoCurrency;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface GeneralActionRepository extends ReactiveCrudRepository<CryptoCurrency, String> {
    Flux<CryptoCurrency> findAllByUserId(String userId);
}
