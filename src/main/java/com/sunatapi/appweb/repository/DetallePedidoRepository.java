package com.sunatapi.appweb.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sunatapi.appweb.model.DetallePedido;
import com.sunatapi.appweb.model.Pedido;

@Repository
public interface  DetallePedidoRepository extends JpaRepository<DetallePedido, Integer>{

    @Query(value = "SELECT o FROM DetallePedido o WHERE o.pedido=?1")
    List<DetallePedido> findItemsByPedido(Pedido pedido);
    
    @Query(value = "SELECT pr.descripcion as descripcion, SUM(o.cantidad) as cantidad, SUM(o.precio*o.cantidad) as montototal  FROM DetallePedido o JOIN o.pedido p JOIN o.product pr GROUP BY pr.descripcion ORDER BY cantidad DESC")
    List<Map<String, Object>> querySumaTotal();


}