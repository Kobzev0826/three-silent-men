package com.accumulator.three.silent.men;

import com.accumulator.three.silent.men.fileread.CsvParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThreeSilentMenApplication  implements CommandLineRunner {



	public static void main(String[] args) {

		SpringApplication.run(ThreeSilentMenApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("test");
		CsvParser.parser();
	}
}
