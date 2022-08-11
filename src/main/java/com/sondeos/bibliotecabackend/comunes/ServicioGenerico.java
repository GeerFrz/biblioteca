package com.sondeos.bibliotecabackend.comunes;

import java.io.Serializable;
import java.util.List;

public interface ServicioGenerico<T, ID extends Serializable> {

    T guardar(T entity);

    void borrar(ID id);

    T obtenerPorId(ID id);

    List<T> obtenerTodos();
}
