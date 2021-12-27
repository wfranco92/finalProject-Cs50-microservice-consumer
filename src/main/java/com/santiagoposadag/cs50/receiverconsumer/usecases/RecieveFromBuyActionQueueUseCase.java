package com.santiagoposadag.cs50.receiverconsumer.usecases;


import org.springframework.stereotype.Component;

@Component
public class RecieveFromBuyActionQueueUseCase {

    public void receiveMessage(String message){
        System.out.println("Received: " + message);
    }
}
