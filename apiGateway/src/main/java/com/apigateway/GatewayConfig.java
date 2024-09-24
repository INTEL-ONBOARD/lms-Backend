package com.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("homeService", r -> r.path("/api/v1/home/**")
                        .uri("http://localhost:8081"))  // HomeService URL
                .route("userService", r -> r.path("/api/v1/user/**")
                        .uri("http://localhost:8082"))  // UserService URL
                .route("orderService", r -> r.path("/api/v1/order/**")
                        .uri("http://localhost:8083"))  // OrderService URL
                .build();
    }
}