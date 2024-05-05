package com.example.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entidades.Cliente;
import com.example.entidades.Producto;
import com.example.servicios.ClienteService;
import com.example.servicios.ProductoService;

@Controller
@RequestMapping("/")
public class Controlador {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProductoService productoService;

    @GetMapping("/listado-clientes")
    public String listarClientes(Model modelo) {
        modelo.addAttribute("clientes", clienteService.listarClientes());
        modelo.addAttribute("cliente", new Cliente());
        return "listado-clientes";
    }

    @GetMapping("/listado-productos")
    public String listarProductos(Model modelo) {
        modelo.addAttribute("productos", productoService.listarProductos());
        modelo.addAttribute("producto", new Producto());
        return "listado-productos";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente) {
        clienteService.guardar(cliente);
        return "redirect:/listado-clientes";
    }

    @PostMapping("/guardarProducto")
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        productoService.guardar(producto);
        return "redirect:/listado-productos";
    }
}
