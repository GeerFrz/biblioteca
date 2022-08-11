package com.sondeos.bibliotecabackend.controladores;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sondeos.bibliotecabackend.prototipos.LibrosPrototipos;
import com.sondeos.bibliotecabackend.servicios.LibrosServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class LibrosControladorTest {

    MockMvc mockMvc;
    LibrosServicio librosServicio;
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        librosServicio = mock(LibrosServicio.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new LibrosControlador()).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void inicioPagina() throws Exception {
    }

    @Test
    void formularioPagina() {
    }

    @Test
    void guardar() {
    }

    @Test
    void borrar() {
    }
}