package com.cpt.payments.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpt.payments.constants.Endpoints;
import com.cpt.payments.dto.Transaction;
import com.cpt.payments.pojo.TransactionReqRes;
import com.cpt.payments.service.paymentStatusService;
import com.cpt.payments.util.TransactionMapper;

@RestController
@RequestMapping(Endpoints.PAYMENTS)
public class PaymentController {
	@Autowired
	paymentStatusService paymentStatusService;

	@Autowired
	TransactionMapper transactionMapper;

	@PostMapping(value = Endpoints.STATUS_UPDATE)
	public ResponseEntity<TransactionReqRes> processPaymentStatus(@RequestBody TransactionReqRes transactionReqRes) 
	{
		//LogMessage.setLogMessagePrefix("/STATUS_UPDATE");
		System.out.println(" payment request is -> " + transactionReqRes);

		Transaction transaction = transactionMapper.toDTO(transactionReqRes);
		System.out.println("tconverted to txn dto"+ transaction);
		Transaction response = paymentStatusService.updatePaymentStatus(transaction);

		TransactionReqRes responseObject = transactionMapper.toResponseObject(response);
		return ResponseEntity.ok(responseObject);
	}



}
