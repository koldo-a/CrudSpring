package com.example.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entidades.Cliente;

@Controller
@RequestMapping("/")
public class Controlador {
	
	@Autowired
    private ClienteService clienteService;
	//TODO crear estos services
	
    @Autowired
    private ProductoService productoService;
  //TODO crear estos services
    
	@RequestMapping("/lista")
	public String index(Model modelo) {
			modelo.addAttribute("cliente", new Cliente()); // Aquí estás agregando un nuevo objeto Plato al modelo
		return "listado-clientes";
	}

}