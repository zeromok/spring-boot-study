package com.example.sburrestdemo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SburRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SburRestDemoApplication.class, args);
	}

	@Bean
	@ConfigurationProperties("droid")
	Droid createDroid() {
		return new Droid();
	}

}

@Getter
@Setter
@ConfigurationProperties("greeting")
class Greeting{
	private String name;
	private String coffee;
}


@Getter
@Setter
class Droid {
	private String id, description;
}
