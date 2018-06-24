package com.example.configclient;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * // @ConfigurationProperties 的改变时直接重新绑定
 * // @RefreshScope不仅仅是重新绑定,它是重新再绑定一个bean.
 * // @RefreshScope的工作原理Spring创建一个代理Proxy,
 * // Proxy中包含注入的依赖及调用目标bean的方法,当更新Refresh时,
 * // 新Proxy就会指向改变的bean,而老的Proxy还指向老的bean.所以它更安全
 */
@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

}
