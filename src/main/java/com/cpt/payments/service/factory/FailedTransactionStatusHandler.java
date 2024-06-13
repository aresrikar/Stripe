package com.cpt.payments.service.factory;

import com.cpt.payments.dto.Transaction;
import com.cpt.payments.service.TransactionStatusHandler;

public class FailedTransactionStatusHandler extends TransactionStatusHandler {

	@Override
	public boolean updateStatus(Transaction transaction) {
		// TODO Auto-generated method stub
		return false;
	}

}
