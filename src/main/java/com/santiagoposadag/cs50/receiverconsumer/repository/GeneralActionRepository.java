package com.santiagoposadag.cs50.receiverconsumer.repository;

import com.santiagoposadag.cs50.receiverconsumer.collections.CryptoCurrency;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface GeneralActionRepository extends ReactiveCrudRepository<CryptoCurrency, String> {
}
