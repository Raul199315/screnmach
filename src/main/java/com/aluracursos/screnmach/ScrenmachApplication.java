package com.aluracursos.screnmach;

import com.aluracursos.screnmach.service.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrenmachApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScrenmachApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoAPI();
		var json = consumoApi.obtenerDatos()
	}
}
