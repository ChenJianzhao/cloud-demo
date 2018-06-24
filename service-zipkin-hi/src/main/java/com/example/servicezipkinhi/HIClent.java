package com.example.servicezipkinhi;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-hi")
public interface HIClent {

	@GetMapping("/hi")
	public String hi(@RequestParam("name") String name);
}
