package org.librarymanagement.security;

import jakarta.annotation.PostConstruct;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {


    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_name, password, enabled from employee where user_name=?");
        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_name, role from employee where user_name=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        // Book management endpoints
                        .requestMatchers(HttpMethod.GET, "/api/books/**").hasAnyAuthority("LIBRARIAN", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/books").hasAnyAuthority("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/books/**").hasAnyAuthority("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/books/**").hasAnyAuthority("MANAGER", "ADMIN")
                        // Patron management endpoints
                        .requestMatchers(HttpMethod.GET, "/api/patrons/**").hasAnyAuthority("LIBRARIAN", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/patrons").hasAnyAuthority("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/patrons/**").hasAnyAuthority("MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/patrons/**").hasAnyAuthority("MANAGER", "ADMIN")
                        // Borrowing endpoints
                        .requestMatchers(HttpMethod.POST, "/api/borrow/**").hasAnyAuthority("LIBRARIAN", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/return/**").hasAnyAuthority("LIBRARIAN", "MANAGER", "ADMIN")
                        // Employee endpoints
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyAuthority("LIBRARIAN", "MANAGER", "ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasAuthority("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasAuthority("ADMIN")
                        .anyRequest().permitAll()
                );
        // use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());
        // disable Cross Site Request Forgery (CSRF)
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

}






