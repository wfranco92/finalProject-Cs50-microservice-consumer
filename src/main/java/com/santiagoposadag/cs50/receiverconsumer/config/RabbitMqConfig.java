package com.santiagoposadag.cs50.receiverconsumer.config;





import com.santiagoposadag.cs50.receiverconsumer.usecases.ReceiveFromUserAuthenticationUseCase;
import com.santiagoposadag.cs50.receiverconsumer.usecases.RecieveFromBuyActionQueueUseCase;
import com.santiagoposadag.cs50.receiverconsumer.usecases.RecieveFromGeneralActionQueueUseCase;
import com.santiagoposadag.cs50.receiverconsumer.usecases.RecieveFromSellActionQueueUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String GENERAL_QUEUE = "action.general";
    public static final String SELL_QUEUE = "action.sell";
    public static final String BUY_QUEUE = "action.buy";
    public static final String AUTHENTICATION_QUEUE = "action.authentication";

    @Autowired
    RecieveFromGeneralActionQueueUseCase generalAction;

    @Autowired
    RecieveFromBuyActionQueueUseCase buyAction;

    @Autowired
    RecieveFromSellActionQueueUseCase sellAction;

    @Autowired
    ReceiveFromUserAuthenticationUseCase authenticationAction;


    @RabbitListener(queues = {GENERAL_QUEUE})
    public void listenerOfGeneralActions(String received){
        generalAction.receiveMessage(received);
    }

    @RabbitListener(queues = SELL_QUEUE)
    public void listenerOfSellActions(String received){
        sellAction.receiveMessage(received);
    }

    @RabbitListener(queues = BUY_QUEUE)
    public void listenerOfBuyActions(String received){
        buyAction.receiveMessage(received);
    }

    @RabbitListener(queues = AUTHENTICATION_QUEUE)
    public void listenerOfAuthenticationActions(String received){
        authenticationAction.receiveMessage(received);
    }
}
