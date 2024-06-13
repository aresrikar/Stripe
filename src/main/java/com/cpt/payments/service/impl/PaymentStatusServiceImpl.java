package com.cpt.payments.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpt.payments.constants.TransactionStatusEnum;
import com.cpt.payments.dto.Transaction;
import com.cpt.payments.service.TransactionStatusHandler;
import com.cpt.payments.service.paymentStatusService;
import com.cpt.payments.service.factory.TransactionStatusFactory;

@Service
public class PaymentStatusServiceImpl implements paymentStatusService {

	@Autowired
	TransactionStatusFactory transactionStatusFactory; 
	
	

	@Override
	public Transaction updatePaymentStatus(Transaction transaction) {
		// TODO Auto-generated method stub
		System.out.println("invoked service class: updated payment status ");

		TransactionStatusEnum statusEnum=TransactionStatusEnum.getTransactionStatusEnum( transaction.getTxnStatusId());

		//factory
		TransactionStatusHandler statusHandler= transactionStatusFactory.getStatusHandler(statusEnum); 
		boolean isupdated=	statusHandler.updateStatus(transaction);
		System.out.println("status handler is |updated"+ isupdated +"|status Enum"+ statusEnum);

		return transaction;
	}

}
