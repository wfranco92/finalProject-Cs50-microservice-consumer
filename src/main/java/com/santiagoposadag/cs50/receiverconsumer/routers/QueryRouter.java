package com.santiagoposadag.cs50.receiverconsumer.routers;


import com.santiagoposadag.cs50.receiverconsumer.dto.BoughtCryptoCurrencyDto;
import com.santiagoposadag.cs50.receiverconsumer.dto.CryptoCurrencyDto;
import com.santiagoposadag.cs50.receiverconsumer.dto.SoldCryptoCurrencyDto;
import com.santiagoposadag.cs50.receiverconsumer.usecases.GetAllActionsFromAUserUseCase;
import com.santiagoposadag.cs50.receiverconsumer.usecases.GetBuyActionsFromAUserUseCase;
import com.santiagoposadag.cs50.receiverconsumer.usecases.GetSellActionsFromAUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class QueryRouter {

    @Bean
    public RouterFunction<ServerResponse> getAllActionsByUserId(GetAllActionsFromAUserUseCase getAllActionsFromAUserUseCase){
        return route(GET("/getAllActions/{userId}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                getAllActionsFromAUserUseCase.apply(request.pathVariable("userId")),
                                CryptoCurrencyDto.class
                        ))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getBuyActionsByUserId(GetBuyActionsFromAUserUseCase getBuyActionsFromAUserUseCase){
        return route(GET("/getBuyActions/{userId}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                getBuyActionsFromAUserUseCase.apply(request.pathVariable("userId")),
                                BoughtCryptoCurrencyDto.class
                        ))
        );
    }

    @Bean
    public RouterFunction<ServerResponse> getSellActionsByUserId(GetSellActionsFromAUserUseCase getSellActionsFromAUserUseCase){
        return route(GET("/getSellActions/{userId}"),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(
                                getSellActionsFromAUserUseCase.apply(request.pathVariable("userID")),
                                SoldCryptoCurrencyDto.class
                        ))
        );
    }

}
