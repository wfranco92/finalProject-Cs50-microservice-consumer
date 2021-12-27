package com.santiagoposadag.cs50.receiverconsumer.usecases;

import com.santiagoposadag.cs50.receiverconsumer.dto.SoldCryptoCurrencyDto;
import com.santiagoposadag.cs50.receiverconsumer.helpers.CryptoCurrencyMappers;
import com.santiagoposadag.cs50.receiverconsumer.repository.SellActionRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
@Validated
public class GetSellActionsFromAUserUseCase implements Function<String, Flux<SoldCryptoCurrencyDto>> {

    private SellActionRepository repository;
    private CryptoCurrencyMappers mapper;

    public GetSellActionsFromAUserUseCase(SellActionRepository repository, CryptoCurrencyMappers mapper){
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Flux<SoldCryptoCurrencyDto> apply(String userId) {
        return repository.findAllByUserId(userId).map(mapper.fromSoldEntityToDto());
    }
}
