package com.example.demo;

import com.netflix.appinfo.EurekaInstanceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableEurekaClient   // just for Eureka
@EnableDiscoveryClient  // for all  implementations of "Discovery Service" (eureka, consul, zookeeper).
@RestController
@EnableHystrix
@EnableCircuitBreaker
public class ServiceHi2Application {

    protected Logger logger = LoggerFactory.getLogger(ServiceHi2Application.class);

    @Autowired
    private EurekaInstanceConfig eurekaInstanceConfig;

    public static void main(String[] args) {
        SpringApplication.run(ServiceHi2Application.class, args);
    }

    @Value("${server.port}")
    String port;
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        this.logger.info("/hi, instanceId:{}, host:{}", eurekaInstanceConfig.getInstanceId(), eurekaInstanceConfig.getHostName(false));

        return "hi "+name+",i am from port:" +port;
    }

}
