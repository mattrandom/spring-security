package io.mattrandom.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("pass").authorities("ADMIN")
                .and()
                .withUser("user").password("pass").authorities("READ")
                .and().passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
