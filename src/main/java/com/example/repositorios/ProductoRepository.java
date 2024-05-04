package com.example.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.entidades.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

}
