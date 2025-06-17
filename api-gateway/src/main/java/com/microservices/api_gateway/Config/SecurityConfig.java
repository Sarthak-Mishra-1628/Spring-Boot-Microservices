package com.microservices.api_gateway.Config;


// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//         http
//             .authorizeExchange(exchanges -> exchanges
//                 .pathMatchers("/eureka/**", "/actuator/**").permitAll()
//                 .anyExchange().authenticated()
//             )
//             .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);

//         return http.build();
//     }
// }

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {

        http
            .authorizeExchange(exchange -> exchange
                .pathMatchers("/eureka/**", "/actuator/**").permitAll()
                .anyExchange().authenticated()
            )
            .exceptionHandling(ex -> ex
                .authenticationEntryPoint((exchange, ex1) -> {
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                })
                .accessDeniedHandler((exchange, ex2) -> {
                    exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                    return exchange.getResponse().setComplete();
                })
            )
            .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);

        return http.build();
    }
}

