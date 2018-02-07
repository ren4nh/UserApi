package com.hartwig.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hartwig.api.documents.Usuario;
import com.hartwig.api.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listarTodos() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario listarPorId(String id) {
		return this.usuarioRepository.findOne(id);
	}

	@Override
	public Usuario listaPorUsername(String username) {
		return this.usuarioRepository.findByUsername(username);
	}

	@Override
	public Usuario salvar(Usuario usuario) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));	
		return this.usuarioRepository.save(usuario);
	}

}
