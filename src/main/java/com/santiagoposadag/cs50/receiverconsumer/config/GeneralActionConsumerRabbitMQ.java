package com.santiagoposadag.cs50.receiverconsumer.config;




import com.santiagoposadag.cs50.receiverconsumer.usecases.RecieveFromBuyActionQueueUseCase;
import com.santiagoposadag.cs50.receiverconsumer.usecases.RecieveFromGeneralActionQueueUseCase;
import com.santiagoposadag.cs50.receiverconsumer.usecases.RecieveFromSellActionQueueUseCase;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralActionConsumerRabbitMQ {

    public static final String GENERAL_QUEUE = "action.general";
    public static final String SELL_QUEUE = "action.sell";
    public static final String BUY_QUEUE = "action.buy";

    public static final String EXCHANGE = "actions_exchange";
    public static final String GENERAL_ROUTING_KEY = "routingKey.*";
    public static final String SELL_ROUTING_KEY = "routingKey.sell";
    public static final String BUY_ROUTING_KEY = "routingKey.buy";


    @Bean
    SimpleMessageListenerContainer containerGeneralAction(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(GENERAL_QUEUE);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(RecieveFromGeneralActionQueueUseCase receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    SimpleMessageListenerContainer containerSellAction(ConnectionFactory connectionFactory,
                                                          MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(SELL_QUEUE);
        container.setMessageListener(listenerAdapter);
        return container;
    }


    @Bean
    SimpleMessageListenerContainer containerBuyAction(ConnectionFactory connectionFactory,
                                                       MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(BUY_QUEUE);
        container.setMessageListener(listenerAdapter);
        return container;
    }


}
