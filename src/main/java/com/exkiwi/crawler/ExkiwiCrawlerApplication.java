package com.exkiwi.crawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class ExkiwiCrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExkiwiCrawlerApplication.class, args);
	}
}
