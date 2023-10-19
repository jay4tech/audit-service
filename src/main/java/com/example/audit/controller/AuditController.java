package com.example.audit.controller;

import com.example.audit.model.AuditEvent;
import com.example.audit.service.IAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("audit")
public class AuditController {

    @Autowired
    IAuditService auditService;


    @PostMapping("/logActivity")
    public void analyzeTransaction(@RequestBody AuditEvent auditEvent) {
        auditService.logActivity(auditEvent);
    }
}
