package net.focik.scopegasconnectionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ScopeGasconnectionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScopeGasconnectionServiceApplication.class, args);
	}

}
