package com.jgm.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/user/**").authenticated() // 인증되면 누구나 갈 수 있다.
		.antMatchers("/manager/**").access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')") // role이 manager거나 admin이면 갈 수 있다.
		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')") // role이 admin인 사람만 갈 수 있다.
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/loginForm")
		.defaultSuccessUrl("/");
	}
}
