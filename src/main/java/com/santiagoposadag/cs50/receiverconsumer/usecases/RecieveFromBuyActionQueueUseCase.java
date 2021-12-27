package com.santiagoposadag.cs50.receiverconsumer.usecases;


import com.google.gson.Gson;
import com.santiagoposadag.cs50.receiverconsumer.collections.BoughtCryptoCurrency;
import com.santiagoposadag.cs50.receiverconsumer.repository.BuyActionRepository;
import org.springframework.stereotype.Component;

@Component
public class RecieveFromBuyActionQueueUseCase {

    private Gson gson = new Gson();
    private BuyActionRepository repository;

    public RecieveFromBuyActionQueueUseCase(BuyActionRepository repository){
        this.repository = repository;
    }

    public void receiveMessage(String message){
        BoughtCryptoCurrency crypto = gson.fromJson(message, BoughtCryptoCurrency.class);
        repository.save(crypto).subscribe();
    }
}
