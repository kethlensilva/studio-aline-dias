package com.studio.aline.dias.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/cadastro", "/css/**", "/js/**", "/images/**").permitAll() // libera páginas HTML e recursos estáticos
                .requestMatchers("/api/login", "/api/cadastrar").permitAll() // libera endpoints da API
                .anyRequest().authenticated() // exige autenticação nas demais rotas
            )
            .formLogin(form -> form
                .loginPage("/login") // indica qual a página customizada de login
                .permitAll()
            )
            .logout(logout -> logout.permitAll());

        return http.build();
    }
}
