package com.example.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Controlador {
	
	@RequestMapping("/lista")
	public String index(Model modelo) {
		return "listado-clientes";
	}

}
