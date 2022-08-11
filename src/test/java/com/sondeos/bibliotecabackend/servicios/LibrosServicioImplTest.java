package com.sondeos.bibliotecabackend.servicios;

import com.sondeos.bibliotecabackend.modelos.Libro;
import com.sondeos.bibliotecabackend.prototipos.LibrosPrototipos;
import com.sondeos.bibliotecabackend.repositorios.LibrosRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LibrosServicioImplTest {

    @Mock
    private LibrosRepositorio librosRepositorio;

    @InjectMocks
    private LibrosServicioImpl librosServicio;

    private Libro libro;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        libro = LibrosPrototipos.libro();
    }

    @Test
    void guardar() {
        when(librosRepositorio.save(any(Libro.class))).thenReturn(libro);
        assertNotNull(librosServicio.guardar(new Libro()));
    }

    @Test
    void borrar() {
        /*
        librosRepositorio.save(libro);
        verify(librosRepositorio, Mockito.times(1)).deleteById(1L);
        */
    }

    @Test
    void obtenerPorId() {
        when(librosRepositorio.findById(1L)).thenReturn(Optional.ofNullable(libro));
        assertNotNull(librosServicio.obtenerPorId(1L));
    }

    @Test
    void obtenerTodos() {
        when(librosRepositorio.findAll()).thenReturn(Arrays.asList(libro));
        assertNotNull(librosServicio.obtenerTodos());
    }
}