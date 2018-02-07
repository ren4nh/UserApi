package com.hartwig.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hartwig.api.documents.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	
	Usuario findByUsername(String username);

}
