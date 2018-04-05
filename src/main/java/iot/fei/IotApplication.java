package iot.fei;

import iot.fei.core.config.LocalDateConverter;
import iot.fei.core.config.LocalTimeConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {
		"iot.fei.core.service, iot.fei.core.config, iot.fei.controller, iot.fei.mapper" })
@EntityScan(basePackages = { "iot.fei.core.domain" })
@Import(value = {LocalDateConverter.class, LocalTimeConverter.class})
public class IotApplication {
	public static void main(String[] args) {
		SpringApplication.run(IotApplication.class, args);
	}
}
