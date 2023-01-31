package org.generation.ecommercedb.service;

import java.util.List;
import java.util.Optional;

import org.generation.ecommercedb.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class UsuarioService {
private final UsuarioRepository usuarioRepository;

@Autowired
private PasswordEncoder passwordEncoder;
@Autowired
public UsuarioService(UsuarioRepository usuarioRepository) {
	this.usuarioRepository = usuarioRepository;
}//constructor




public List<Usuario> getAllUsuarios(){
	return usuarioRepository.findAll();
}


public Usuario getAUsuario(Long id){
	return usuarioRepository.findById(id).orElseThrow(
			()-> new IllegalArgumentException("El usuario con el id " + id + "no existe.")
			);
}

public Usuario deleteUsuario(Long id) {
	Usuario tmp = null;
	if (usuarioRepository.existsById(id)) {
		tmp=usuarioRepository.findById(id).get();
	}else {
		System.out.println("El usuario con el id " + id + "no existe.");
	}
	return tmp;
}//deleteusuario






public Usuario addAUsuario(Usuario usuario){
	usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
	return usuarioRepository.save(usuario);
}


public Usuario updateuUsuario(Long id, String password, String newpassword) {
	Usuario tmp=null;
	if (usuarioRepository.existsById(id)) {
		tmp=usuarioRepository.findById(id).get();
		if(password!=null && (newpassword!=null)) {
			//if (password.equals(tmp.getPassword())) {
			if (passwordEncoder.matches(password, tmp.getPassword())){
			tmp.setPassword(newpassword);
				usuarioRepository.save(tmp);
			}else {
				tmp=null;
			}//if password
		} //if !=null
		
	}else {
		
		System.out.println("Update - El Usuario con el id " + id + "no existe");
	}
	return tmp;
}

public boolean validaUsuario(Usuario usuario) {
	
	Optional<Usuario> userByEmail=usuarioRepository.findByEmail(usuario.getEmail());
	if (userByEmail.isPresent()) {
		Usuario u = userByEmail.get();
		if (u.getPassword().equals(usuario.getPassword())) {
			return true;
		}//if equals
	}//if is present
	
	return false;
}//validaUsuario





}//class UsuarioService
