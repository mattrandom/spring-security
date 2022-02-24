package io.mattrandom.repository;

import io.mattrandom.model.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {

    List<Card> findByCustomerId(int customerId);
}