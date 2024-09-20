//package br.com.paqueradebar.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecConfig {
//
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//		return http.csrf(csrf -> csrf.disable())
//				.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
//						.requestMatchers("/login", "/css/**", "/images/**", "/js/**", "/usuario/**").permitAll() // permite todos
//						.anyRequest().authenticated() // so autenticado
////				.oauth2Login(oauth2 -> oauth2.loginPage("/login") // Página de login customizada (opcional)
//				).build();
//	}
//}
