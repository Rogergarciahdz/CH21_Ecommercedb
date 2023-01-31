package org.generation.ecommercedb.controller;

import java.util.List;

import org.generation.ecommercedb.model.Producto;
import org.generation.ecommercedb.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path ="/api/productos/")

public class ProductoController {
private final ProductoService productoService;

@Autowired
public ProductoController(ProductoService productoService) {
	this.productoService=productoService;
}

@GetMapping
public List<Producto> getAllProductos(){
	return productoService.getAllProductos();
}

@GetMapping(path = "{prodId}")//http://localhost:8080/api/productos/1
public Producto getProducto(@PathVariable("prodId") Long Id) {
	return productoService.getProducto(Id);
}

@DeleteMapping(path = "{prodId}")//http://localhost:8080/api/productos/1
public Producto deleteProducto(@PathVariable("prodId") Long Id) {
	return productoService.deleteProducto(Id);
}

@PostMapping
public Producto addProducto(@RequestBody Producto producto) {
	return productoService.addProducto(producto);
}


@PutMapping(path = "{prodId}")//http://localhost:8080/api/productos/1
public Producto updateProducto(@PathVariable("prodId") Long Id,
	@RequestParam(required = false) String nombre,
	@RequestParam(required = false) String descripcion,
	@RequestParam(required = false) String imagen,
	@RequestParam(required = false) Double precio) {
	
	return productoService.updateProducto(Id, nombre, descripcion, imagen, precio);
}

	
	



	
}
