package io.mattrandom.controller;

import io.mattrandom.model.Account;
import io.mattrandom.model.Customer;
import io.mattrandom.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping("/myAccount")
	public String getAccountDetails(String input) {
		return "Here are the account details from the DB";
	}

	@PostMapping("/myAccount")
	public Account getAccountDetails(@RequestBody Customer customer) {
		Account accountByCustomerId = accountRepository.findByCustomerId(customer.getId());

		if (accountByCustomerId != null) {
			return accountByCustomerId;
		} else {
			return null;
		}
	}

}
