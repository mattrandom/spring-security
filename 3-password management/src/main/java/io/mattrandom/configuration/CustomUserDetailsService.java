package io.mattrandom.configuration;

import io.mattrandom.model.Customer;
import io.mattrandom.model.CustomerUserDetails;
import io.mattrandom.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Customer> customers = customerRepository.findByEmail(username);

        if (customers.size() == 0) {
            throw new UsernameNotFoundException("CustomerUserDetails not found for the user: " + username);
        }

//         List<Customer> customers = customerRepository.findByEmail(username)
//                .orElseThrow(() -> new UsernameNotFoundException("CustomerUserDetails not found for the user: " + username));

        return new CustomerUserDetails(customers.get(0));
    }
}
