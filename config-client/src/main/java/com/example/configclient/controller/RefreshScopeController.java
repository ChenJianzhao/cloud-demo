package com.example.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 【1】使用 @RefreshScope 来更新读取配置中心的的值
 * config-client 需要加此注解，在 post /refresh 之后才能刷新值
 * 并且需要关闭安全认证 management.security.enabled=false
 */
@RestController
@RefreshScope
public class RefreshScopeController {

	@Value("${foo}")
	String foo;

	@RequestMapping(value = "/hi")
	public String hi(){
		return foo;
	}
}
