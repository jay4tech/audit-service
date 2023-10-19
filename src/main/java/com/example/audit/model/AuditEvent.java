package com.example.audit.model;

import lombok.Data;

@Data
public class AuditEvent<T> {
    public Long auditId;
    public String auditType;
    public T eventData;
}
