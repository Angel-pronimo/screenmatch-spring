package com.aluracursos.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(ScreenmatchApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    var consumoApi = new ConsumoAPI();
    var json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&&apikey=4fc7c187");
    System.out.println(json);
    ConvierteDatos conversor = new ConvierteDatos();
    var datos =  conversor.obtenerDatos(json, DatosSerie.class);
    System.out.println(datos);
  }
}
