package com.hartwig.api.service;

import java.util.List;

import com.hartwig.api.documents.Usuario;

public interface UsuarioService {
	
	List<Usuario> listarTodos();
	
	Usuario listarPorId(String id);
	
	Usuario listaPorUsername(String username);
	
	Usuario salvar(Usuario usuario);

}
