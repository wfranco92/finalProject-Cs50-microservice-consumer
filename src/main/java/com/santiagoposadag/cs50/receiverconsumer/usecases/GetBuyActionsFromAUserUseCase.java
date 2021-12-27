package com.santiagoposadag.cs50.receiverconsumer.usecases;

import com.santiagoposadag.cs50.receiverconsumer.dto.BoughtCryptoCurrencyDto;
import com.santiagoposadag.cs50.receiverconsumer.helpers.CryptoCurrencyMappers;
import com.santiagoposadag.cs50.receiverconsumer.repository.BuyActionRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
@Validated
public class GetBuyActionsFromAUserUseCase implements Function<String, Flux<BoughtCryptoCurrencyDto>> {

    private BuyActionRepository repository;
    private CryptoCurrencyMappers mapper;

    public GetBuyActionsFromAUserUseCase(BuyActionRepository repository, CryptoCurrencyMappers mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Flux<BoughtCryptoCurrencyDto> apply(String userId) {
        return repository.findAllByUserId(userId).map(mapper.fromBuyEntityToDto());
    }
}
