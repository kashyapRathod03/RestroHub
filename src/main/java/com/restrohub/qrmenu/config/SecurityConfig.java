package com.restrohub.qrmenu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) {
		
		try {
			http.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(req->req.requestMatchers("/pubblic/**").permitAll()
						.anyRequest().authenticated())
				.formLogin(Customizer.withDefaults())
				.logout(req-> req.logoutUrl("/logout"));
				
			return http.build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
