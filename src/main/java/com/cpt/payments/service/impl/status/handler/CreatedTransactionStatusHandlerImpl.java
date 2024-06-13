package com.cpt.payments.service.impl.status.handler;

import org.springframework.stereotype.Service;

import com.cpt.payments.dto.Transaction;
import com.cpt.payments.service.TransactionStatusHandler;

@Service
public class CreatedTransactionStatusHandlerImpl extends TransactionStatusHandler {

	@Override
	public boolean updateStatus(Transaction transaction) {

		System.out.println("created status invoked"+ transaction);
		return false;
	}

}
