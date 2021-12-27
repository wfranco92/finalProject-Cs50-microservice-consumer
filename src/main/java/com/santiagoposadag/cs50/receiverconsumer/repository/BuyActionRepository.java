package com.santiagoposadag.cs50.receiverconsumer.repository;

import com.santiagoposadag.cs50.receiverconsumer.collections.BoughtCryptoCurrency;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BuyActionRepository extends ReactiveCrudRepository<BoughtCryptoCurrency, String> {
}