package com.zikan.todomanagementproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

//    mAKE a password Encoder

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests((authorize) -> {
//  this means all the incoming post request that starts with url /api should
//  be accessible by all the users with Admin roles
                    authorize.requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN");
                    authorize.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails zikan = User.builder()
                .username("Isaac")
                .password(passwordEncoder().encode("Anawana"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("Sunny")
                .password(passwordEncoder().encode("Anas"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(zikan, admin);

    }
}
