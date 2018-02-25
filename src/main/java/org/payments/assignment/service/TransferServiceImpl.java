package org.payments.assignment.service;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.payments.assignment.constants.TransferServiceConstants;
import org.payments.assignment.dao.TransferServiceDao;
import org.payments.assignment.entity.Account;
import org.payments.assignment.entity.Transfer;
import org.payments.assignment.exception.InsufficientFundsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SHUBHAM
 *
 * TransferServiceImpl provides an implementation of TransferService Interface. It provides following features.
 * 1) get list of all transfers
 * 2) transfer money from one account to another
 * 
 * It also performs various validation prior to execution of transaction. 
 */
@Service
public class TransferServiceImpl implements TransferService {

	private static final Logger log = LoggerFactory.getLogger(TransferService.class);	
	
	@Autowired
	TransferServiceDao transferServiceDao;

	@Transactional(rollbackOn=Exception.class)
	public Account executeTransaction(Transfer transaction) throws Exception {

		Account senderAccount = transferServiceDao.getAccount(transaction.getSenderAccountNumber());
		Account receiverAccount = transferServiceDao.getAccount(transaction.getReceiverAccountNumber());
	
			if(senderAccount !=null && receiverAccount !=null) {
				if(senderAccount.getBalance()>transaction.getAmount()) {
					//initiating transaction
					transaction.setTimestamp(new Date());
					transaction.setStatus(TransferServiceConstants.STATUS_INITIATED);
					Transfer savedTransaction = transferServiceDao.addTransaction(transaction);
					log.info("Transaction Initiated");
					//executing transaction
					senderAccount.setBalance(senderAccount.getBalance()-transaction.getAmount());
					receiverAccount.setBalance(receiverAccount.getBalance()+transaction.getAmount());
					transferServiceDao.updateAccount(senderAccount.getAccountNumber(), senderAccount);
					transferServiceDao.updateAccount(receiverAccount.getAccountNumber(),receiverAccount);
					savedTransaction.setStatus(TransferServiceConstants.STATUS_SUCCESS);
					transferServiceDao.updateTransaction(savedTransaction);
					//validating transaction
					transferServiceDao.getAccount(senderAccount.getAccountNumber());
					Transfer finalTransaction = transferServiceDao.getTransaction(savedTransaction.getId());
					if(finalTransaction.getStatus().equalsIgnoreCase(TransferServiceConstants.STATUS_SUCCESS)){
						log.info("Transaction completed successfully");
					}
					else {
						log.error("Transaction failed");
						throw new Exception(TransferServiceConstants.TRANSACTION_FAILED);					}
					
				}
				else {
					throw new InsufficientFundsException(TransferServiceConstants.INSUFFICIENT_FUNDS);
				}
		
			}
			return senderAccount;
	}



	public List<Transfer> getAllTransfers() {
	return transferServiceDao.getAllTransaction();
	}



}
