package com.santiagoposadag.cs50.receiverconsumer.usecases;

import com.santiagoposadag.cs50.receiverconsumer.dto.UserDTO;
import com.santiagoposadag.cs50.receiverconsumer.helpers.UserAuthenticationMappers;
import com.santiagoposadag.cs50.receiverconsumer.repository.UserAuthenticationRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
@Validated
public class GetAllAuthenticationsUseCase implements Function<String, Flux<UserDTO>> {

    private UserAuthenticationRepository repository;
    private UserAuthenticationMappers mapper;

    public GetAllAuthenticationsUseCase(UserAuthenticationRepository repository, UserAuthenticationMappers mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Flux<UserDTO> apply(String name) {
        return repository.findAllByName(name).map(mapper.fromUserEntityToDTO());
    }
}
