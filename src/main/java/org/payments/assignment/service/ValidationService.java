package org.payments.assignment.service;


import org.payments.assignment.constants.TransferServiceConstants;
import org.payments.assignment.entity.Transfer;
import org.springframework.stereotype.Service;

/**
 * @author SHUBHAM
 * 
 * ValidationService validates the transaction and returns true, if the transaction is successfully validated. 
 * If the validation fails, it provides appropriate message to the user about, what Api expects.
 *
 */
@Service
public class ValidationService {

	public boolean validate(Transfer transaction) throws Exception {
		
		if(transaction.getSenderAccountNumber()==0) {
			throw new Exception(TransferServiceConstants.SENDER_ACCOUNT_EMPTY);
		}
		
		else if(transaction.getReceiverAccountNumber()==0) {
			throw new Exception(TransferServiceConstants.RECEIVER_ACCOUNT_EMPTY);
		}
		
		else if(transaction.getAmount()<0) {
			throw new Exception(TransferServiceConstants.NEGATIVE_AMOUNT);
		}
		else {
			return true;
		}
		
	}

	

}
