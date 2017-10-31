package iot.fei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {
		"iot.fei.core.service, iot.fei.core.config, iot.fei.controller" })
@EntityScan(basePackages = { "iot.fei.core.domain" })
public class IotApplication {
	public static void main(String[] args) {
		SpringApplication.run(IotApplication.class, args);
	}
}
