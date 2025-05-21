package com.aluracursos.screnmach;

import com.aluracursos.screnmach.model.DatosSerie;
import com.aluracursos.screnmach.service.ConsumoAPI;
import com.aluracursos.screnmach.service.ConvierteDatos;
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
		var json = consumoApi.obtenerDatos( "https://www.omdbapi.com/?t=game+of+thrones&apikey=5523bf38");
		System.out.println(json);

		ConvierteDatos converson = new ConvierteDatos();
		var datos = converson.obtenerDatos(json, DatosSerie.class);
		System.out.println(datos);
	}
}
