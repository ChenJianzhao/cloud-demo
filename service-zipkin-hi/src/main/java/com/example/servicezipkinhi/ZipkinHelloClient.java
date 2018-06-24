package com.example.servicezipkinhi;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("service-zipkin-hello")
public interface ZipkinHelloClient {

	@GetMapping("/zipkin")
	public String hello();
}
