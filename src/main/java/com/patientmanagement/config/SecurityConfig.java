//package com.patientmanagement.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		return http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/tofservice/getall").permitAll() // với endpoint /hello thì sẽ được cho qua
//                .and()
//                .authorizeHttpRequests()
//                .requestMatchers("/customer/**").authenticated() // với endpoint /customer/** sẽ yêu cầu authenticate
//                .and().formLogin() // trả về page login nếu chưa authenticate
//                .and().build();
//		
//	}
//}
