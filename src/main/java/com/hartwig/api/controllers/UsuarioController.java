package com.hartwig.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hartwig.api.documents.Usuario;
import com.hartwig.api.responses.Response;
import com.hartwig.api.service.UsuarioService;

@RestController
@RequestMapping(path = "/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(path = "/auth")
	public ResponseEntity<Response<Usuario>> logar(@RequestBody Usuario usuario) {
		Usuario user = this.usuarioService.listaPorUsername(usuario.getUsername());
		if(user != null) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			if(passwordEncoder.matches(usuario.getPassword(), user.getPassword())) {
				return ResponseEntity.ok(new Response<Usuario>(user));
			} else {
				return ResponseEntity.badRequest().body(new Response<Usuario>("Password incorrect"));
			}
		}
		return ResponseEntity.badRequest().body(new Response<Usuario>("User not found"));
	}
	
	@PostMapping(path = "/create")
	public ResponseEntity<Response<Usuario>> create(@RequestBody Usuario usuario) {
		return ResponseEntity.ok(new Response<Usuario>(this.usuarioService.salvar(usuario)));
	}
	
	@GetMapping
	public ResponseEntity<Response<List<Usuario>>> listAll() {
		return ResponseEntity.ok(new Response<List<Usuario>>(this.usuarioService.listarTodos()));
	}

}
