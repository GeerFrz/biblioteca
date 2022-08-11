package com.sondeos.bibliotecabackend.servicios;

import com.sondeos.bibliotecabackend.comunes.ServicioGenericoImpl;
import com.sondeos.bibliotecabackend.modelos.Libro;
import com.sondeos.bibliotecabackend.repositorios.LibrosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LibrosServicioImpl extends ServicioGenericoImpl<Libro, Long> implements LibrosServicio{

    @Autowired
    private LibrosRepositorio librosRepositorio;

    @Override
    public JpaRepository<Libro, Long> obtenerRepositorio() {
        return librosRepositorio;
    }
}
