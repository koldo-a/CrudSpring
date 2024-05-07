package com.example.servicios;

import java.util.List;
import com.example.entidades.Producto;

public interface ProductoService {
    Iterable<Producto> listarProductos();
    void guardar(Producto producto);
    void borrar(Long id);
}
