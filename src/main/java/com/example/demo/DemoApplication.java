package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
    public CommandLineRunner demo() {
	    return args -> {
            Flux<String> s = Flux.fromArray(new String[]{"1", "2", "3", "4"});

            s.map(Integer::parseInt)
                    .filter(i -> i % 2 == 0)
                    .subscribe(System.out::print);
        };
    }
}
