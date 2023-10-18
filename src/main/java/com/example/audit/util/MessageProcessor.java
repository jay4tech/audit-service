package com.example.audit.util;



import com.example.audit.client.AccountTransactionClient;
import com.example.audit.model.AccountDetails;
import com.example.audit.model.TransactionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProcessor {

    @Autowired
    AccountTransactionClient accountTransactionClient;


    public void processMessage(TransactionEvent transactionEvent) {
        AccountDetails accountDetails = accountTransactionClient.getAccountDetails(transactionEvent.getAccountNo());
        /**
         * Audit all the transation
         */
    }


}
