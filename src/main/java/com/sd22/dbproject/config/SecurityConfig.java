package com.sd22.dbproject.config;
/*
import com.sd22.dbproject.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
*/

//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
public class SecurityConfig {
/*
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(auth -> auth
                        .mvcMatchers("/api/counties/**", "/api/locations/**",
                                "/api/reviews/**","/api/tags/**", "/api/trips/**",
                                "/api/packages/**").hasAuthority("USER")
                        .mvcMatchers("/api/users/**").hasAuthority("ADMIN")
                        .anyRequest().authenticated())
                .userDetailsService(myUserDetailsService)
                .httpBasic()
                .and()
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); //For testing
        //return new BCryptPasswordEncoder(); //TODO: encode password
    }*/
}
