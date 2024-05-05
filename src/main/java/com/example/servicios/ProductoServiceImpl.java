package com.example.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entidades.Producto;
import com.example.repositorios.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;
	
    private List<Producto> productos = new ArrayList<>();

    @Override
    public List<Producto> listarProductos() {
        return productos;
    }

    @Override
    public void guardar(Producto producto) {
		producto.setId(null);
		productoRepository.save(producto);
    }
}
