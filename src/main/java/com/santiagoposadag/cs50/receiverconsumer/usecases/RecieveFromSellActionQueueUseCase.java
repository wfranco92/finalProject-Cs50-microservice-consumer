package com.santiagoposadag.cs50.receiverconsumer.usecases;


import com.google.gson.Gson;
import com.santiagoposadag.cs50.receiverconsumer.collections.SoldCryptoCurrency;
import com.santiagoposadag.cs50.receiverconsumer.repository.SellActionRepository;
import org.springframework.stereotype.Component;

@Component
public class RecieveFromSellActionQueueUseCase {

    private Gson gson = new Gson();
    private SellActionRepository repository;

    public RecieveFromSellActionQueueUseCase(SellActionRepository repository){
        this.repository = repository;
    }

    public void receiveMessage(String message){
        SoldCryptoCurrency crypo = gson.fromJson(message, SoldCryptoCurrency.class);
        repository.save(crypo).subscribe();
    }
}
