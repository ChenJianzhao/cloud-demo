package com.example.servicezipkinhello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@SpringBootApplication
@RestController
@SpringCloudApplication
@EnableFeignClients
public class ServiceZipkinHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZipkinHelloApplication.class, args);
    }

    private static final Logger LOG = Logger.getLogger(ServiceZipkinHelloApplication.class.getName());


//    @RequestMapping("/hi")
//    public String home(){
//        LOG.log(Level.INFO, "hi is being called");
//        return "hi i'm miya!";
//    }
//
//    @RequestMapping("/miya")
//    @HystrixCommand
//    public String info(){
//        LOG.log(Level.INFO, "info is being called");
//        return restTemplate.getForObject("http://localhost:8988/zipkinhi",String.class);
//    }
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Bean
//	@LoadBalanced
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }

	@Autowired
	ZipkinHiClient zipkinHClient;
    @Autowired
    HIClent hiClent;

	@GetMapping("/zipkin")
	public String zipkin() {
		return hiClent.hi("cjz");
	}

	@GetMapping("/hello")
	public String hello() {
		return zipkinHClient.hi();
	}
}
