package com.cpt.payments.service.factory;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.cpt.payments.constants.TransactionStatusEnum;
import com.cpt.payments.service.TransactionStatusHandler;
import com.cpt.payments.service.impl.status.handler.CreatedTransactionStatusHandlerImpl;

@Component
public class TransactionStatusFactory {

	private static final Logger LOGGER = LogManager.getLogger(TransactionStatusFactory.class);
	@Autowired
	private ApplicationContext context;

	public TransactionStatusHandler getStatusHandler(TransactionStatusEnum transactionStatusEnum) {
		System.out.println(" fetching transaction status handler for -> "+transactionStatusEnum);
		switch(transactionStatusEnum) {
		case CREATED:
			return context.getBean(CreatedTransactionStatusHandlerImpl.class);
		default:
			return null;
		}

	}
}