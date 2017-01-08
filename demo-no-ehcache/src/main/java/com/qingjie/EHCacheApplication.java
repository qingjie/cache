package com.qingjie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class EHCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(EHCacheApplication.class, args);

	}
}
