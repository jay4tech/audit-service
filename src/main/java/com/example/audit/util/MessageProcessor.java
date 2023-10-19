package com.example.audit.util;


import com.example.audit.model.AuditEvent;
import org.springframework.stereotype.Service;

@Service
public class MessageProcessor {



    public void processMessage(AuditEvent transactionEvent) {
         /**
         * Audit all the transation
         */
    }
}
