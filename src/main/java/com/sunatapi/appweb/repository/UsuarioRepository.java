package com.sunatapi.appweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunatapi.appweb.model.Usuario;

@Repository
public interface  UsuarioRepository extends JpaRepository<Usuario, String>{

    
}