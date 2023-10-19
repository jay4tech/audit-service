package com.example.audit.service;

import com.example.audit.model.AuditEvent;
import org.springframework.stereotype.Service;

@Service
public class AuditService implements IAuditService{

    @Override
    public void logActivity(AuditEvent auditEvent) {

    }
}
