package com.example.audit.util;

import com.example.audit.model.AuditEvent;
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

    @Value("${queue.name.audit}")
    private String queueNameEvent;

    @Bean(name = "queueEvent")
    public Queue queueEvent() {
        return new Queue(queueNameEvent, true);
    }

    @Autowired
    MessageProcessor messageProcessor;


    @RabbitListener(queues = {"${queue.name.audit}"})
    public void receiveDebitCredit(@Payload String message) {
        try {
            System.out.println("Message " + message);
            AuditEvent auditEvent = (AuditEvent) UtilityMapper.stringToModel(message, AuditEvent.class);
            messageProcessor.processMessage(auditEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}