package com.santiagoposadag.cs50.receiverconsumer.repository;

import com.santiagoposadag.cs50.receiverconsumer.collections.BoughtCryptoCurrency;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BuyActionRepository extends ReactiveCrudRepository<BoughtCryptoCurrency, String> {
    Flux<BoughtCryptoCurrency> findAllByUserId(String userId);
}
