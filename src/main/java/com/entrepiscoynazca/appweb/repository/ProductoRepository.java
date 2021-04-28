package com.entrepiscoynazca.appweb.repository;

import com.entrepiscoynazca.appweb.model.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ProductoRepository extends JpaRepository<Producto, Integer>{

    
}