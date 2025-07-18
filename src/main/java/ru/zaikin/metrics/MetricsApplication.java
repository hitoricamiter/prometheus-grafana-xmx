package ru.zaikin.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MetricsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetricsApplication.class, args);
	}

	@Bean
	MeterBinder meterBinder() {
		return registry -> {
			Counter.builder("greetings_count")
					.description("Количество обращений")
					.register(registry);

			Counter.builder("greetings_count_by_name")
					.description("Количество обращений по имени")
					.tag("name", "user")
					.register(registry);
		};


	}

}
