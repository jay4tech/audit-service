package com.example.audit.service;


import com.example.audit.model.AuditEvent;

public interface IAuditService {
    void logActivity(AuditEvent auditEvent);
}
