package com.accumulator.three.silent.men;

import com.accumulator.three.silent.men.config.YMLManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {


	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		YMLManager.manage("src/main/resources/config.yaml");
	}
}
