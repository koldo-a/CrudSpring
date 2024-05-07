package com.example.servicios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entidades.Producto;
import com.example.entidades.Usuario;
import com.example.repositorios.ClienteRepository;
import com.example.repositorios.ProductoRepository;
import com.example.repositorios.UsuarioRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;

	private Iterable<Producto> productos = new ArrayList<>();

	@Override
	public Iterable<Producto> listarProductos() {
		productos = productoRepository.findAll();
		return productos;
	}

	@Override
	public void guardar(Producto producto) {
		producto.setId(null);
		productoRepository.save(producto);
	}
	@Override
	public void borrar(Long id) {
		productoRepository.deleteById(id);
	}
//    comentario
	public ProductoServiceImpl(UsuarioRepository usuarioRepository, ProductoRepository productoRepository,
			ClienteRepository clienteRepository) {
		usuarioRepository.save(Usuario.builder().nombre("Javier").email("javier@email.net")
				.password("$2a$12$mof.u/4EIo58hR7On9DnPevyqBC7kb9FHzT.LN/BjF8xOqQVTP1NO").rol("ADMIN").build());
		usuarioRepository.save(Usuario.builder().nombre("Koldo").email("koldo@email.net")
				.password("$2a$12$NhIMIVI5wNYc97crXmW9rupNsEbeea1BxPu.H0gSDkiDQrhhmXeZO").rol("ADMIN").build());
		usuarioRepository.save(Usuario.builder().nombre("Pepe").email("pepe@email.net")
				.password("$2a$12$Dij9cgV3mXDQYtOo4nvQTOLaUz3URoe7DGjhBrqGa1fEEzkNVhBgq").rol("USER").build());
	}
}