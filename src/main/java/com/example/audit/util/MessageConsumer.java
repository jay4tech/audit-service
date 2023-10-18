package com.example.audit.util;

import com.example.audit.model.TransactionEvent;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${queue.name.debitCredit}")
    private String queueDebitCredit;

    @Bean(name = "queueDebitCredit")
    public Queue queueDebitCredit() {
        return new Queue(queueDebitCredit, true);
    }

    @Autowired
    MessageProcessor messageProcessor;


    @RabbitListener(queues = {"${queue.name.debitCredit}"})
    public void receiveDebitCredit(@Payload String message) {
        try {
            System.out.println("Message " + message);
            TransactionEvent transactionEvent = (TransactionEvent) UtilityMapper.stringToModel(message, TransactionEvent.class);
            messageProcessor.processMessage(transactionEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}