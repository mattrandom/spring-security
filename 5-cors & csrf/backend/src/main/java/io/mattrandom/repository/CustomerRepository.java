package io.mattrandom.repository;

import io.mattrandom.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByEmail(String email);

//    Optional<List<Customer>> findByEmail(String email);
}