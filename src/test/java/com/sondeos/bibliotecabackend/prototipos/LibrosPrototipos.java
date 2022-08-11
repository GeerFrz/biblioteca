package com.sondeos.bibliotecabackend.prototipos;

import com.sondeos.bibliotecabackend.modelos.Libro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class LibrosPrototipos {

    public static Libro libro(){
        Libro libro = new Libro();

        libro.setId(1L);
        libro.setTitulo("Fahrenheit 451");
        libro.setAutor("Ray Bradbury");
        libro.setPrecio(BigDecimal.valueOf(2500.50));
        libro.setFechaLanzamiento(LocalDate.parse("1953-10-19"));

        return libro;
    }

    public static List<Libro> libros(){
        List<Libro> libros = new ArrayList<>();
        libros.add(libro());

        Libro libro = new Libro();

        libro.setId(2L);
        libro.setTitulo("Frankenstein; or, The Modern Prometheus");
        libro.setAutor("Mary Shelley");
        libro.setPrecio(BigDecimal.valueOf(2700));
        libro.setFechaLanzamiento(LocalDate.parse("1818-01-01"));

        libros.add(libro);

        return libros;
    }

}
