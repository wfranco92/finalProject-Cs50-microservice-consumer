package com.santiagoposadag.cs50.receiverconsumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SoldCryptoCurrencyDto {


    private String Id;
    private String cryptoCurrencyName;
    private double price;
    private String dateOfAction;
    private String typeOfAction;
    private double quantity;
    private String userId;
    private String routingKey;
}
