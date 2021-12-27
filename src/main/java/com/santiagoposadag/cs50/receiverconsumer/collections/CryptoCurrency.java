package com.santiagoposadag.cs50.receiverconsumer.collections;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class CryptoCurrency implements Serializable {


    @Id
    private String Id;
    private String cryptoCurrencyName;
    private double price;
    private String dateOfAction;
    private String typeOfAction;
    private double quantity;
    private String userId;
    private String routingKey;
}
