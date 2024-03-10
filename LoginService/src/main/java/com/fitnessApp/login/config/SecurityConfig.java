package com.fitnessApp.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fitnessApp.login.security.jwt.JWTAuthenticationFilter;
import com.fitnessApp.login.security.jwt.JwtAuthenticationEntryPoint;

@Configuration
public class SecurityConfig {

	@Autowired
	private JwtAuthenticationEntryPoint point;
	@Autowired
	private JWTAuthenticationFilter filter;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable()).authorizeRequests().requestMatchers("/api").authenticated()
				.requestMatchers("/auth/login").permitAll().requestMatchers("/register").permitAll().anyRequest()
				.authenticated().and().exceptionHandling(ex -> ex.authenticationEntryPoint(point))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
}
