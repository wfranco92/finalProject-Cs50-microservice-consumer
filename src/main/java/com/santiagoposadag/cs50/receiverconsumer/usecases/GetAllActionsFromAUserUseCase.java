package com.santiagoposadag.cs50.receiverconsumer.usecases;

import com.santiagoposadag.cs50.receiverconsumer.dto.CryptoCurrencyDto;
import com.santiagoposadag.cs50.receiverconsumer.helpers.CryptoCurrencyMappers;
import com.santiagoposadag.cs50.receiverconsumer.repository.GeneralActionRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;


@Service
@Validated
public class GetAllActionsFromAUserUseCase implements Function<String, Flux<CryptoCurrencyDto>> {

    private GeneralActionRepository repository;
    private CryptoCurrencyMappers mapper;

    public GetAllActionsFromAUserUseCase(CryptoCurrencyMappers mapper, GeneralActionRepository repository){
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Flux<CryptoCurrencyDto> apply(String userId) {
        return repository.findAllByUserId(userId).map(mapper.fromGeneralEntityToDto());
    }
}
