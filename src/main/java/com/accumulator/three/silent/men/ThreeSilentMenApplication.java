package com.accumulator.three.silent.men;

import com.accumulator.three.silent.men.model.Manager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ThreeSilentMenApplication  implements CommandLineRunner {



	public static void main(String[] args) {

		SpringApplication.run(ThreeSilentMenApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Manager.start("src/main/resources");
	}
}
