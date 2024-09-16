//package br.com.paqueradebar.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
////@EnableWebSecurity
//public class SecConfig {
//
//	@Bean
//	public SecurityFilterChain secureFilterChain(HttpSecurity http) throws Exception {
//		return http.authorizeHttpRequests(request -> {
//			request.requestMatchers("/", "/usuario/**").permitAll();
//			// request.anyRequest().authenticated();
//		}).build();
////				.oauth2Login(Customizer.withDefaults()).formLogin(Customizer.withDefaults()).build();
////				.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/home", true))
////				.oauth2Login(oauth2 -> oauth2.loginPage("/login").defaultSuccessUrl("/", true))
//	}
//}
