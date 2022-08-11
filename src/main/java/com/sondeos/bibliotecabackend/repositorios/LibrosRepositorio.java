package com.sondeos.bibliotecabackend.repositorios;

import com.sondeos.bibliotecabackend.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrosRepositorio extends JpaRepository<Libro, Long> {
}
