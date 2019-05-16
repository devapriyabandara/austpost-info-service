/*
    Basic security implementation for APIs
*/

package com.austpost.locationinfoservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /*
        Defines basic security and authentications for APIs
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/locationservice/all").permitAll() // permit all the request to /all API without any authentication
                .antMatchers(HttpMethod.GET,"/locationservice/getsuburb/**").permitAll() // permit all the request to /getsuburb API without any authentication
                .antMatchers(HttpMethod.GET,"/locationservice/getpostcode/**").permitAll()  // permit all the request to /getpostcode API without any authentication
                .antMatchers(HttpMethod.POST,"/locationservice/add").hasRole("ADMIN")  // to access add API need to provide credentials and get authenticated
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()
                .httpBasic();
    }


    /*
        Setup basic user credentials for a ADMIN role in order to validate for /add API
     */
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {

        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser("administrator")
                .password("{noop}administrator")
                .roles("ADMIN");
    }
}
