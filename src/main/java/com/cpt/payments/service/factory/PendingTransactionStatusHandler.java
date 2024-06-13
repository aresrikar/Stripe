package com.cpt.payments.service.factory;

import com.cpt.payments.dto.Transaction;
import com.cpt.payments.service.TransactionStatusHandler;

public class PendingTransactionStatusHandler extends TransactionStatusHandler {

	@Override
	public boolean updateStatus(Transaction transaction) {
		// TODO Auto-generated method stub
		return false;
	}

}
