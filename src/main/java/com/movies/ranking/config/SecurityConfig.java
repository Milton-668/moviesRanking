package com.movies.ranking.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Log4j2
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Desabilita o token
        http.csrf().disable().authorizeHttpRequests()
                //Gera o token para habilitação
                //http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and().authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                //habilita formulários de login and logout
                .formLogin()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        log.info("Password encoded {}", passwordEncoder.encode("test"));
        auth.inMemoryAuthentication()
                .withUser("junior")
                .password(passwordEncoder.encode("academy"))
                .roles("USER", "ADMIN")
                .and()
                .withUser("maycon")
                .password(passwordEncoder.encode("academy"))
                .roles("USER");
    }
}
