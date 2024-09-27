package br.com.paqueradebar.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(auth -> auth.requestMatchers("/", "/login", "/css/**", "/images/**", "/js/**")
				.permitAll().anyRequest().authenticated())
				.oauth2Login(oauth -> oauth.loginPage("/login").defaultSuccessUrl("/home", true)).logout()
				.logoutUrl("/perform-logout").logoutSuccessUrl("/") // Redirecionar após o logout
				.invalidateHttpSession(true) // Invalida a sessão do usuário
				.deleteCookies("JSESSIONID"); // Remove o cookie de sessão
		return http.build();
	}
}
