//package br.com.paqueradebar.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity
//@Configuration
//public class SecConfig {
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf(csrf -> csrf.disable()) // Desabilita CSRF
//				.authorizeHttpRequests(authz -> authz.requestMatchers("/login/**", "/oauth2/**").permitAll() // Permite
//																												// acesso
//																												// sem
//																												// autenticação
//						.anyRequest().authenticated() // Requer autenticação para todas as outras requisições
//				).oauth2Login(oauth2 -> oauth2.defaultSuccessUrl("/home") // URL após o login bem-sucedido
//						.failureUrl("/login?error=true") // URL em caso de falha no login
//				).oauth2ResourceServer(oauth2 -> oauth2.jwt()); // Configura o servidor de recursos para aceitar JWT
//		return http.build();
//	}
//}
