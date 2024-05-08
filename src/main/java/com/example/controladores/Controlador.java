package com.example.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entidades.Cliente;
import com.example.entidades.Producto;
import com.example.servicios.ClienteService;
import com.example.servicios.ProductoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class Controlador {
	
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/")
    public String mostrarPaginaPrincipal(Model modelo) {
        // Lógica para preparar el modelo si es necesario
        return "index"; 
    }

    @GetMapping("/listado-clientes")
    public String listarClientes(Model modelo) {
        modelo.addAttribute("clientes", clienteService.listarClientes());
        modelo.addAttribute("cliente", new Cliente());
        return "listado-clientes";
    }
    
    @GetMapping("/error")
    public String error(Model modelo) {
        return "error";
    }

    @GetMapping("/listado-productos")
    public String listarProductos(Model modelo) {
        modelo.addAttribute("productos", productoService.listarProductos());
        modelo.addAttribute("producto", new Producto());
        return "listado-productos";
    }

	@PostMapping("/guardarCliente")
	public String guardarCliente(@Valid Cliente cliente, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("error de entrada");
			return "listado-clientes";
		}
		
		clienteService.guardar(cliente);
		
		return "redirect:/listado-clientes";
	}
	
    @PostMapping("/guardarProducto")
    public String guardarProducto(@Valid Producto producto, BindingResult bindingResult ) {
    	if(bindingResult.hasErrors()) {
			System.out.println("error de entrada");
			return "listado-productos";
		}
        productoService.guardar(producto);
        
        return "redirect:/listado-productos";
    }
    
    @GetMapping("borrarCliente/{id}")
	public String borrarCliente(@PathVariable Long id) {
		clienteService.borrar(id);
		
		return "redirect:/listado-clientes";
	}
    
    @GetMapping("borrarProducto/{id}")
	public String borrarProducto(@PathVariable Long id) {
		productoService.borrar(id);
		
		return "redirect:/listado-productos";
	}
    
//    @GetMapping("editarCliente/{id}")
//	public String editarCliente(@PathVariable Long id, Model modelo) {
//		clienteService.modificar(modelo);
//	}
    
	@GetMapping("login")
	public String login() {
		return "login";
	}
}
