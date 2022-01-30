package com.wonderlabz.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/conversions/ktoc")
                        .uri("http://localhost:8080"))
                .route(p -> p.path("/conversions/ctok")
                        .uri("http://localhost:8080"))
				.route(p -> p.path("/conversions/mtok")
						.uri("http://localhost:8080"))
				.route(p -> p.path("/conversions/ktom")
						.uri("http://localhost:8080"))
                .route(p -> p
                        .path("/conversions")
                        .uri("http://localhost:8080"))
                .build();
    }
}
