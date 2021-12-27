package com.santiagoposadag.cs50.receiverconsumer.repository;

import com.santiagoposadag.cs50.receiverconsumer.collections.CryptoCurrency;
import com.santiagoposadag.cs50.receiverconsumer.collections.SoldCryptoCurrency;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SellActionRepository extends ReactiveCrudRepository<SoldCryptoCurrency, String>{
    Flux<SoldCryptoCurrency> findAllByUserId(String userId);
}
