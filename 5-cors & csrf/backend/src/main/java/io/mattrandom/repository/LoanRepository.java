package io.mattrandom.repository;

import io.mattrandom.model.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer> {

    List<Loan> findByCustomerIdOrderByStartDtDesc(int customerId);
}