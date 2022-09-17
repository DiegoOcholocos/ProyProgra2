package com.sunatapi.appweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sunatapi.appweb.model.Pedido;

@Repository
public interface  PedidoRepository extends JpaRepository<Pedido, Integer>{

    @Query(value = "SELECT o FROM Pedido o WHERE o.clienteId=?1")
    List<Pedido> findItemsByCliente(Integer clienteId);

}