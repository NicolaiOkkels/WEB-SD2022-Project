package com.sd22.dbproject.security;
import com.sd22.dbproject.security.jwt.JwtAuthEntryPoint;
import com.sd22.dbproject.security.jwt.JwtAuthenticationFilter;
import com.sd22.dbproject.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private JwtAuthEntryPoint authEntryPoint;

    private MyUserDetailsService myUserDetailsService;

    @Autowired
    public SecurityConfig(MyUserDetailsService myUserDetailsService, JwtAuthEntryPoint authEntryPoint) {
        this.myUserDetailsService = myUserDetailsService;
        this.authEntryPoint = authEntryPoint;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()//.csrf()
                //.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                //.and()
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .mvcMatchers("/api/auth/**", "/api/trips/**","/api/users/**").permitAll()
                //.antMatchers("api/csrf").permitAll()
                //.mvcMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(myUserDetailsService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(){
        return new JwtAuthenticationFilter();
    }
}

