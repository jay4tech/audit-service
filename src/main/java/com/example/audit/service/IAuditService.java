package com.example.audit.service;

import com.example.audit.model.TransactionEvent;


public interface IAuditService {
    void logActivity(TransactionEvent transactionEvent);
}
