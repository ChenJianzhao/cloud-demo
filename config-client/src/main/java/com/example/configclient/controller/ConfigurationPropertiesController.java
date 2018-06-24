package com.example.configclient.controller;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 【2】使用 @ConfigurationProperties 来更新读取配置中心的的值
 * 	注意去掉@Value注解,和添加getter/setter
 * config-client 需要加此注解，在 post /refresh 之后才能刷新值
 * 并且需要关闭安全认证 management.security.enabled=false
 */
@RestController
@ConfigurationProperties
@Data
public class ConfigurationPropertiesController {

	String foo;

	@RequestMapping(value = "/hi2")
	public String hi(){
		return foo;
	}
}
