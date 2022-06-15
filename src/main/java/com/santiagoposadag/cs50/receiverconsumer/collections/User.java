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
public class User implements Serializable {

    @Id
    private String Id;
    private String nameUser;
    private String lastNameUser;
    private String DNIUser;
    private String routingKey;

}
