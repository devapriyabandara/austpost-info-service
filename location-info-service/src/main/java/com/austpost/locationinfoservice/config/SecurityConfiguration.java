package com.austpost.locationinfoservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/locationservice/all").permitAll()
                .antMatchers(HttpMethod.GET,"/locationservice/getsuburb/**").permitAll()
                .antMatchers(HttpMethod.GET,"/locationservice/getpostcode/**").permitAll()
                .antMatchers(HttpMethod.POST,"/locationservice/add").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("administrator")
                .password("{noop}administrator")
                .roles("ADMIN");
    }
}
