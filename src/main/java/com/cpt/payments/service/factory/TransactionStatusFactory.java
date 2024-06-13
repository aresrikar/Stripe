package com.cpt.payments.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.log.LogMessage;
import org.springframework.stereotype.Component;

import com.cpt.payments.constants.TransactionStatusEnum;
import com.cpt.payments.service.TransactionStatusHandler;
import com.cpt.payments.service.impl.status.handler.ApprovedTransactionStatusHandler;
import com.cpt.payments.service.impl.status.handler.CreatedTransactionStatusHandlerImpl;

@Component
public class TransactionStatusFactory {

	@Autowired
	private ApplicationContext context;

	public TransactionStatusHandler getStatusHandler(TransactionStatusEnum transactionStatusEnum) {
		System.out.println(" fetching transaction status handler for -> "+transactionStatusEnum);
		switch(transactionStatusEnum) {
		case CREATED:
			return context.getBean(CreatedTransactionStatusHandlerImpl.class);
		case APPROVED:
			return context.getBean(ApprovedTransactionStatusHandler.class);
		case FAILED:	
			return context.getBean(FailedTransactionStatusHandler.class);
		case PENDING:	
			return context.getBean(PendingTransactionStatusHandler.class);
		default:
			return null;
		}

	}
}