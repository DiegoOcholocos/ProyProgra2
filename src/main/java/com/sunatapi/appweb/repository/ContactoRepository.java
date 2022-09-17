package com.sunatapi.appweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunatapi.appweb.model.Contacto;

@Repository
public interface  ContactoRepository extends JpaRepository<Contacto, Integer>{

    
}