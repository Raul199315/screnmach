package com.aluracursos.screnmach.principal;

import com.aluracursos.screnmach.model.DatosEpisodio;
import com.aluracursos.screnmach.model.DatosSerie;
import com.aluracursos.screnmach.model.DatosTemporada;
import com.aluracursos.screnmach.service.ConsumoAPI;
import com.aluracursos.screnmach.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
       private Scanner teclado = new Scanner(System.in);
       private ConsumoAPI  consumoApi= new ConsumoAPI();
       private  final String URL_BASE = "https://www.omdbapi.com/?t=";
       private  final String API_KEY = "&apikey=5523bf38";
       private ConvierteDatos conversor = new ConvierteDatos();

        public void muestraElmenu() {
            System.out.printf("Por favor escribe el nombre de la serie que deseas buscar");
            /// busca los datos generales de la serie
            var nombreSerie = teclado.nextLine();
            var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
            var datos = conversor.obtenerDatos(json, DatosSerie.class);

            //busca los datos de todas las temporadas
            List<DatosTemporada> temporadas = new ArrayList<>();
            for (int i = 1; i <=datos.totalTemporadas() ; i++) {
                json= consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season=" +i+ API_KEY);
                var datosTemporadas = conversor.obtenerDatos(json, DatosTemporada.class);
                temporadas.add(datosTemporadas);
            }
            //temporadas.forEach(System.out::println);

            // mostrar solo el titulo de los episodios para las temporadas
            for (int i = 0; i < datos.totalTemporadas(); i++) {
                List<DatosEpisodio> episodiosTemporadas = temporadas.get(i).episodios();
                for (int j = 0; j < episodiosTemporadas.size(); j++) {
                    System.out.printf(episodiosTemporadas.get(j).titulo());

                }
            }
            temporadas.forEach(t -> t.episodios().forEach(e -> System.out.printf(e.titulo())));
    }
}