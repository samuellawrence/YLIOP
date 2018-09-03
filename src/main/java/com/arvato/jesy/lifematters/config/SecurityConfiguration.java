package com.arvato.jesy.lifematters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration {// extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        /*httpSecurity.authorizeRequests()
                .antMatchers("/").permitAll().and().authorizeRequests()
                .antMatchers("/h2-console/**").permitAll();

        httpSeBeancurity.csrf().disable();
                httpSecurity.headers().frameOptions().disable();
    */ }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}