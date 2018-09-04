package com.arvato.jesy.lifematters.config;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.arvato.jesy.lifematters.googlesheets.SheetsServiceUtil;
import com.google.api.services.sheets.v4.Sheets;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class GoogleSheetConfig {// extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity httpSecurity) throws Exception {
        /*httpSecurity.authorizeRequests()
                .antMatchers("/").permitAll().and().authorizeRequests()
                .antMatchers("/h2-console/**").permitAll();

        httpSeBeancurity.csrf().disable();
                httpSecurity.headers().frameOptions().disable();
    */ }

    @Bean
    public Sheets googleSheet() {
        try {
			return SheetsServiceUtil.getSheetsService();
		} catch (IOException e) {
			// TODO Auto-generated catch block
            throw new RuntimeException(e);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
    }

}