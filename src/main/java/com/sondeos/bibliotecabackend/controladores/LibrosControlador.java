package com.sondeos.bibliotecabackend.controladores;

import com.sondeos.bibliotecabackend.modelos.Libro;
import com.sondeos.bibliotecabackend.servicios.LibrosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class LibrosControlador {

    @Autowired
    private LibrosServicio librosServicio;

    @RequestMapping("/")
    public String inicioPagina(Model model){
        model.addAttribute("tituloPagina", "Listado de libros");
        model.addAttribute("libros", librosServicio.obtenerTodos());

        return "home";
    }

    @RequestMapping(value = {"/formulario", "/formulario/{id}"})
    public String formularioPagina(@PathVariable(name="id") Optional<Long> idLibro, Model model){

        String titulo = "Agregar libro";

        if(idLibro.isPresent() && idLibro.get() > 0){
            titulo = "Editar libro";
            model.addAttribute("libro", librosServicio.obtenerPorId(idLibro.get()));
        }

        model.addAttribute("tituloPagina", titulo);

        return "formulario-libro";
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> guardar(@RequestBody Libro libro){

        Libro res = librosServicio.guardar(libro);

        if(res != null){
            return new ResponseEntity<>("Datos guardados", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error al intentar guardar los datos", HttpStatus.FAILED_DEPENDENCY);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public String borrar(@PathVariable("id") Long id, Model model){

        librosServicio.borrar(id);

        return "redirect:/";
    }
}
