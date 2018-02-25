package org.payments.assignment;

import org.payments.assignment.dao.AccountRepository;
import org.payments.assignment.dao.TransactionRepository;
import org.payments.assignment.entity.Account;
import org.payments.assignment.entity.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author SHUBHAM
 *
 *  TransferServiceBootApplication bootstraps the complete application and initialize all the beans. It also creates
 *  some dummy accounts & transaction data into the database in order to test the various features of this api.
 *
 */
@SpringBootApplication
public class TransferServiceBootApplication {
	
	private static final Logger log = LoggerFactory.getLogger(TransferServiceBootApplication.class);	
	
	public static void main(String[] args) {
		SpringApplication.run(TransferServiceBootApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(AccountRepository repository, TransactionRepository transactionRepository) {
		return (args) -> {
		
		//Adding dummy accounts
		log.info("creating some dummy accounts with some monetory balance")	;
		
		repository.save(new Account(123456789, 5000, "Shubham"));
		repository.save(new Account(557684573, 10000, "Mark"));
		repository.save(new Account(889987343, 8000, "John"));
		repository.save(new Account(343343453, 12000, "Marie"));
		
		//fetch all customers
		log.info("fetching all accounts with findAll();");
		log.info("-------------------------------------");
		for(Account account:repository.findAll()) {
			log.info(account.getAccountHolderName()+ " : " + account.getAccountNumber() + " : " + account.getBalance());
		}
		
		log.info("-----Inserting one dummy transaction -------");
		Transfer transfer = transactionRepository.save(new Transfer(889987343, 343343453, 500));
		log.info(transfer.getSenderAccountNumber() + " : " + transfer.getReceiverAccountNumber() + " : " + transfer.getAmount());
		};
		
	}
}
