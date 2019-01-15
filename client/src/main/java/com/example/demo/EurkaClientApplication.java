package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class EurkaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurkaClientApplication.class, args);
	}

   @Value("${server.port}")
   String port;
   
   @Value("${demo.hello}")
   private String path;
   
   
    @RequestMapping("/")
    public String home(String addressCode) {
    	System.out.println(addressCode);
        // "hello world from port " + port + " path:" + path;
        return "SUCCESS";
    }
    
    @RequestMapping("/hello")
    public String hello() {
    	return "hello called. " + path;
    }
	
}

