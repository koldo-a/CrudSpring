package com.example.servicios;

import java.util.List;
import com.example.entidades.Producto;

public interface ProductoService {
    List<Producto> listarProductos();
    void guardar(Producto producto);
}
