package com.aluracursos.screnmach;

import com.aluracursos.screnmach.model.DatosEpisodio;
import com.aluracursos.screnmach.model.DatosSerie;
import com.aluracursos.screnmach.model.DatosTemporada;
import com.aluracursos.screnmach.service.ConsumoAPI;
import com.aluracursos.screnmach.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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
		json= consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&episode=1&apikey=5523bf38");
		DatosEpisodio episodio = converson.obtenerDatos(json, DatosEpisodio.class);
		System.out.printf(String.valueOf(episodio));


		List<DatosTemporada> temporadas = new ArrayList<>();
		for (int i = 1; i <=datos.totalTemporadas() ; i++) {
			json= consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season="+i+"&apikey=5523bf38");
			var datosTemporadas = converson.obtenerDatos(json, DatosTemporada.class);
			temporadas.add(datosTemporadas);
		}
		temporadas.forEach(System.out::println);
	}
}
