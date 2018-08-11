package com.tuobuxie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author lishaofeng
 */
@EnableZuulProxy
@SpringBootApplication
@EnableHystrix

public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

//    @Bean
//    public TokenFilter tokenFilter() {
//        return new TokenFilter();
//    }
}
