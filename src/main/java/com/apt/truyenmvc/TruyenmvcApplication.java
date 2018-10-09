package com.apt.truyenmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableEncryptableProperties
@SpringBootApplication
public class TruyenmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruyenmvcApplication.class, args);
	}
}
