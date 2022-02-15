package io.mattrandom.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * /myAccount - Secured
     * /myBalance - Secured
     * /myLoans - Secured
     * /myCards - Secured
     * /notices - Not Secured
     * /contact - Not Secured
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/myAccount/**").authenticated()
                    .antMatchers("/myBalance/**").authenticated()
                    .antMatchers("/myLoans/**").authenticated()
                    .antMatchers("/myCards/**").authenticated()
                    .anyRequest().permitAll()
                    .and()
                .formLogin()
                .and()
                .httpBasic();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("pass").authorities("ADMIN")
//                .and()
//                .withUser("user").password("pass").authorities("READ")
//                .and().passwordEncoder(NoOpPasswordEncoder.getInstance());
//    }


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        UserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//
//        UserDetails user = User.withUsername("admin").password(passwordEncoder().encode("pass")).authorities("ADMIN").build();
//        UserDetails user2 = User.withUsername("user").password(passwordEncoder().encode("pass")).authorities("USER").build();
//
//        userDetailsService.createUser(user);
//        userDetailsService.createUser(user2);
//
//        auth.userDetailsService(userDetailsService);
//    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
