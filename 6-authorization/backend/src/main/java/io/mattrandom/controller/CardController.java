package io.mattrandom.controller;

import io.mattrandom.model.Card;
import io.mattrandom.model.Customer;
import io.mattrandom.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {

	@Autowired
	private CardRepository cardRepository;

	@PostMapping("/myCards")
	public List<Card> getCardDetails(@RequestBody Customer customer) {
		List<Card> cards = cardRepository.findByCustomerId(customer.getId());

		if (cards != null ) {
			return cards;
		}else {
			return null;
		}
	}
	
	@GetMapping("/myCards")
	public String getCardDetails(String input) {
		return "Here are the card details from the DB";
	}

}
