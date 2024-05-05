package com.example.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entidades.Cliente;
import com.example.repositorios.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public List<Cliente> listarClientes() {
        return clientes;
    }

    @Override
    public void guardar(Cliente cliente) {
		cliente.setId(null);
		clienteRepository.save(cliente);
    }
}
