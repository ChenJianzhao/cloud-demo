package com.example.servicezipkinhello;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service-zipkin-hi")
public interface ZipkinHiClient {

	@GetMapping("/zipkin")
	public String hi();
}
