package com.example.servicezipkinhi;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
@SpringCloudApplication
@EnableFeignClients
public class ServiceZipkinHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZipkinHiApplication.class, args);
    }

    private static final Logger LOG = Logger.getLogger(ServiceZipkinHiApplication.class.getName());


//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Bean
//	@LoadBalanced
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }
//
//    @RequestMapping("/hi")
//    @HystrixCommand
//    public String callHome(){
//        LOG.log(Level.INFO, "calling trace service-hi  ");
//        return restTemplate.getForObject("http://localhost:8989/miya", String.class);
//    }
//    @RequestMapping("/zipkinhi")
//    public String info(){
//        LOG.log(Level.INFO, "calling trace service-hi ");
//
//        return "i'm service-hi";
//
//    }

	@Autowired
	ZipkinHelloClient zipkinHelloClient;
	@Autowired
	HIClent hiClent;

	@GetMapping("/zipkin")
	public String zipkin() {
		return hiClent.hi("cjz");
	}

	@GetMapping("/hi")
	public String hi() {
		return zipkinHelloClient.hello();
	}
}

