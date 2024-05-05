package com.example.servicios;

import java.util.List;

import com.example.entidades.Cliente;

public interface ClienteService {
    List<Cliente> listarClientes();
    void guardar(Cliente cliente);
}
