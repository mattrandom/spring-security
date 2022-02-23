package io.mattrandom.controller;

import io.mattrandom.model.AccountTransactions;
import io.mattrandom.model.Customer;
import io.mattrandom.repository.AccountTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {

    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;

    @PostMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestBody Customer customer) {
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.
                findByCustomerIdOrderByTransactionDtDesc(customer.getId());
        if (accountTransactions != null) {
            return accountTransactions;
        } else {
            return null;
        }
    }

    @GetMapping("/myBalance")
    public String getBalanceDetails(String input) {
        return "Here are the balance details from the DB";
    }

}
