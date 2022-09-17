package com.sunatapi.appweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunatapi.appweb.model.Pago;

@Repository
public interface  PagoRepository extends JpaRepository<Pago, Integer>{

    
}