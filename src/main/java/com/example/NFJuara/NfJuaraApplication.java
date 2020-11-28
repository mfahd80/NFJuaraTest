package com.example.NFJuara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class NfJuaraApplication {

	public static void main(String[] args) {
		SpringApplication.run(NfJuaraApplication.class, args);
	}

}
