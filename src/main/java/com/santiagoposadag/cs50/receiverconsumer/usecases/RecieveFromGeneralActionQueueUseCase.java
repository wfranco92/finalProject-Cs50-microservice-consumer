package com.santiagoposadag.cs50.receiverconsumer.usecases;


import com.google.gson.Gson;
import com.santiagoposadag.cs50.receiverconsumer.collections.CryptoCurrency;
import com.santiagoposadag.cs50.receiverconsumer.repository.GeneralActionRepository;
import org.springframework.stereotype.Component;


@Component
public class RecieveFromGeneralActionQueueUseCase {

    private Gson gson = new Gson();
    private GeneralActionRepository repository;

    public RecieveFromGeneralActionQueueUseCase(GeneralActionRepository repository){
        this.repository = repository;
    }

    public void receiveMessage(String message){

        CryptoCurrency crypto = gson.fromJson(message, CryptoCurrency.class);
        repository.save(crypto).subscribe();
    }
}
