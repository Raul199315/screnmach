package com.aluracursos.screnmach;

import com.aluracursos.screnmach.model.DatosEpisodio;
import com.aluracursos.screnmach.model.DatosSerie;
import com.aluracursos.screnmach.model.DatosTemporada;
import com.aluracursos.screnmach.principal.Principal;
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
		Principal principal = new Principal();
		principal.muestraElmenu();

	}
}
