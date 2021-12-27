package com.santiagoposadag.cs50.receiverconsumer.helpers;

import com.santiagoposadag.cs50.receiverconsumer.collections.BoughtCryptoCurrency;
import com.santiagoposadag.cs50.receiverconsumer.collections.CryptoCurrency;
import com.santiagoposadag.cs50.receiverconsumer.collections.SoldCryptoCurrency;
import com.santiagoposadag.cs50.receiverconsumer.dto.BoughtCryptoCurrencyDto;
import com.santiagoposadag.cs50.receiverconsumer.dto.CryptoCurrencyDto;
import com.santiagoposadag.cs50.receiverconsumer.dto.SoldCryptoCurrencyDto;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CryptoCurrencyMappers {

    public Function<CryptoCurrency, CryptoCurrencyDto> fromGeneralEntityToDto(){
        return crypto -> {
            var cryptoCurrencyDto = new CryptoCurrencyDto();
            cryptoCurrencyDto.setId(crypto.getId());
            cryptoCurrencyDto.setCryptoCurrencyName(crypto.getCryptoCurrencyName());
            cryptoCurrencyDto.setPrice(crypto.getPrice());
            cryptoCurrencyDto.setDateOfAction(crypto.getDateOfAction());
            cryptoCurrencyDto.setTypeOfAction(crypto.getTypeOfAction());
            cryptoCurrencyDto.setQuantity(crypto.getQuantity());
            cryptoCurrencyDto.setUserId(crypto.getUserId());
            cryptoCurrencyDto.setRoutingKey(crypto.getRoutingKey());
            return cryptoCurrencyDto;
        };
    }

    public Function<BoughtCryptoCurrency, BoughtCryptoCurrencyDto> fromBuyEntityToDto(){
        return crypto -> {
            var boughtCryptoCurrencyDto = new BoughtCryptoCurrencyDto();
            boughtCryptoCurrencyDto.setId(crypto.getId());
            boughtCryptoCurrencyDto.setCryptoCurrencyName(crypto.getCryptoCurrencyName());
            boughtCryptoCurrencyDto.setPrice(crypto.getPrice());
            boughtCryptoCurrencyDto.setDateOfAction(crypto.getDateOfAction());
            boughtCryptoCurrencyDto.setTypeOfAction(crypto.getTypeOfAction());
            boughtCryptoCurrencyDto.setQuantity(crypto.getQuantity());
            boughtCryptoCurrencyDto.setUserId(crypto.getUserId());
            boughtCryptoCurrencyDto.setRoutingKey(crypto.getRoutingKey());
            return boughtCryptoCurrencyDto;
        };
    }

    public Function<SoldCryptoCurrency, SoldCryptoCurrencyDto> fromSoldEntityToDto(){
        return crypto -> {
            var soldCryptoCurrencyDto = new SoldCryptoCurrencyDto();
            soldCryptoCurrencyDto.setId(crypto.getId());
            soldCryptoCurrencyDto.setCryptoCurrencyName(crypto.getCryptoCurrencyName());
            soldCryptoCurrencyDto.setPrice(crypto.getPrice());
            soldCryptoCurrencyDto.setDateOfAction(crypto.getDateOfAction());
            soldCryptoCurrencyDto.setTypeOfAction(crypto.getTypeOfAction());
            soldCryptoCurrencyDto.setQuantity(crypto.getQuantity());
            soldCryptoCurrencyDto.setUserId(crypto.getUserId());
            soldCryptoCurrencyDto.setRoutingKey(crypto.getRoutingKey());
            return soldCryptoCurrencyDto;
        };
    }

    public Function<CryptoCurrencyDto, CryptoCurrency> fromGeneralDtoToEntity(){
        return crypto ->{
            var cryptoCurrency = new CryptoCurrency();
            cryptoCurrency.setId(crypto.getId());
            cryptoCurrency.setCryptoCurrencyName(crypto.getCryptoCurrencyName());
            cryptoCurrency.setPrice(crypto.getPrice());
            cryptoCurrency.setDateOfAction(crypto.getDateOfAction());
            cryptoCurrency.setTypeOfAction(crypto.getTypeOfAction());
            cryptoCurrency.setQuantity(crypto.getQuantity());
            cryptoCurrency.setUserId(crypto.getUserId());
            cryptoCurrency.setRoutingKey(crypto.getRoutingKey());
            return cryptoCurrency;
        };
    }

    public Function<BoughtCryptoCurrencyDto, BoughtCryptoCurrency> fromBuyDtoToEntity(){
        return crypto -> {
            var boughtCryptoCurrency = new BoughtCryptoCurrency();
            boughtCryptoCurrency.setId(crypto.getId());
            boughtCryptoCurrency.setCryptoCurrencyName(crypto.getCryptoCurrencyName());
            boughtCryptoCurrency.setPrice(crypto.getPrice());
            boughtCryptoCurrency.setDateOfAction(crypto.getDateOfAction());
            boughtCryptoCurrency.setTypeOfAction(crypto.getTypeOfAction());
            boughtCryptoCurrency.setQuantity(crypto.getQuantity());
            boughtCryptoCurrency.setUserId(crypto.getUserId());
            boughtCryptoCurrency.setRoutingKey(crypto.getRoutingKey());
            return boughtCryptoCurrency;
        };
    }

    public Function<SoldCryptoCurrencyDto, SoldCryptoCurrency> fromSoldDtoToEntity(){
        return crypto -> {
            var soldCryptoCurrency = new SoldCryptoCurrency();
            soldCryptoCurrency.setId(crypto.getId());
            soldCryptoCurrency.setCryptoCurrencyName(crypto.getCryptoCurrencyName());
            soldCryptoCurrency.setPrice(crypto.getPrice());
            soldCryptoCurrency.setDateOfAction(crypto.getDateOfAction());
            soldCryptoCurrency.setTypeOfAction(crypto.getTypeOfAction());
            soldCryptoCurrency.setQuantity(crypto.getQuantity());
            soldCryptoCurrency.setUserId(crypto.getUserId());
            soldCryptoCurrency.setRoutingKey(crypto.getRoutingKey());
            return soldCryptoCurrency;
        };
    }
}
