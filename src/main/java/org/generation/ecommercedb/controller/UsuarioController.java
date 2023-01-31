package org.generation.ecommercedb.controller;

import java.util.List;

import org.generation.ecommercedb.model.Usuario;
import org.generation.ecommercedb.service.ChangePassword;
import org.generation.ecommercedb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/usuarios/")
public class UsuarioController {
private final UsuarioService usuarioService;

@Autowired
public UsuarioController(UsuarioService usuarioService) {
this.usuarioService=usuarioService;	
}

@GetMapping
public List<Usuario>getUsuarios(){
	return usuarioService.getAllUsuarios();
	
}


@DeleteMapping(path = "{userId}")
public Usuario deleteUsuario(@PathVariable("userId")Long id) {
	return usuarioService.deleteUsuario(id);
}


@PostMapping
public Usuario addUsuario(@RequestBody Usuario usuario) {
	return usuarioService.addAUsuario(usuario);
}



@PutMapping(path ="{userId}")//http://localhost:8080/api/usuarios/1
public Usuario updateUsuario(@PathVariable("userId") Long id, 
		@RequestBody ChangePassword changePassword) {
	return usuarioService.updateuUsuario(id, changePassword.getPassword(),changePassword.getNewPassword());
}




}
