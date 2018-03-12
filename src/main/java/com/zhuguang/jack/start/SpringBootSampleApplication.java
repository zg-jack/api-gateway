package com.zhuguang.jack.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.netflix.zuul.FilterProcessor;
import com.zhuguang.jack.filter.CustomFilterProcessor;
import com.zhuguang.jack.filter.SecurityFilter;

@EnableZuulProxy
@SpringBootApplication(scanBasePackages = {"com.zhuguang.jack"})
@EnableCircuitBreaker
//@SpringCloudApplication
//注册到eureka
@EnableEurekaClient
public class SpringBootSampleApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleApplication.class, args);
        FilterProcessor.setProcessor(new CustomFilterProcessor());
    }
    
    @Bean
    public SecurityFilter securityFilter() {
        return new SecurityFilter();
    }
}
