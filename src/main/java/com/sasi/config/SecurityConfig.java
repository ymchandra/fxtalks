package com.sasi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by myelleswarapu on 18-04-2017.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.httpBasic(); // issue a 401 to force basic auth

        http.authorizeRequests()
                .antMatchers("/health").permitAll()
                .antMatchers("/info").permitAll()
                .antMatchers("/metrics").permitAll()
                .antMatchers("/env").permitAll()
                .antMatchers("/dump").permitAll()
                .antMatchers("/trace").permitAll()
                .antMatchers("/metrics").permitAll()
                .anyRequest().permitAll();
        http.formLogin().disable(); // disable the default Spring Boot form login
        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("admin").password("admin").roles("SUPER_ADMIN");
    }
}
