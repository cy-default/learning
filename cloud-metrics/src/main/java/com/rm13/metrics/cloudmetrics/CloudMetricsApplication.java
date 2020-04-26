package com.rm13.metrics.cloudmetrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class CloudMetricsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudMetricsApplication.class, args);
	}

}
