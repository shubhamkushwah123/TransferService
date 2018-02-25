package org.payments.assignment.dao;

import org.payments.assignment.entity.Transfer;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transfer,Long>{

}
