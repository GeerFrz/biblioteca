package com.sondeos.bibliotecabackend.comunes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class ServicioGenericoImpl<T, ID extends Serializable> implements ServicioGenerico<T, ID> {
    @Override
    public T guardar(T entity) {
        return obtenerRepositorio().save(entity);
    }

    @Override
    public void borrar(ID id) {
        try {
            obtenerRepositorio().deleteById(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public T obtenerPorId(ID id) {
        Optional<T> obj = obtenerRepositorio().findById(id);
        if (obj.isPresent()) {
            return obj.get();
        }

        return null;
    }

    @Override
    public List<T> obtenerTodos() {
        List<T> lista = new ArrayList<>();
        obtenerRepositorio().findAll().forEach(obj -> lista.add(obj));

        return lista;
    }

    public abstract JpaRepository<T, ID> obtenerRepositorio();
}
