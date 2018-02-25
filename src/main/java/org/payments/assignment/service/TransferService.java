package org.payments.assignment.service;

import java.util.List;

import org.payments.assignment.entity.Account;
import org.payments.assignment.entity.Transfer;
import org.springframework.stereotype.Service;

@Service
public interface TransferService {

	public Account executeTransaction(Transfer transaction) throws Exception;
	
	public List<Transfer> getAllTransfers();
}
