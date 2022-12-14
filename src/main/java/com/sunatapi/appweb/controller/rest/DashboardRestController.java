package com.sunatapi.appweb.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunatapi.appweb.repository.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.*;

@RestController
@RequestMapping(value = "api/dashboard", produces = "application/json")
public class DashboardRestController {

    private final DetallePedidoRepository pedidosData;

    public DashboardRestController(DetallePedidoRepository pedidosData){
        this.pedidosData = pedidosData;
    } 

    @GetMapping(value = "/pedidostotales", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Map<String, Object>>> productos(){
        return  new ResponseEntity<List<Map<String, Object>>>(
            pedidosData.querySumaTotal(), HttpStatus.OK);
    }


}