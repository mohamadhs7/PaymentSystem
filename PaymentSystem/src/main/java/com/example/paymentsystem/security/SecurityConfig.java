package com.example.paymentsystem.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/public/**").permitAll() // Allow access to public resources
                .anyRequest().authenticated() // Require authentication for any other request
                .and()
                .formLogin() // Enable form-based login
                .loginPage("/login") // Specify the login page URL
                .defaultSuccessUrl("/dashboard") // Redirect to the dashboard after successful login
                .and()
                .logout() // Enable logout
                .logoutUrl("/logout") // Specify the logout URL
                .logoutSuccessUrl("/login?logout") // Redirect to login page with a logout parameter
                .and()
                .csrf().disable(); // Disable CSRF protection for simplicity (not recommended for production)
    }
}
