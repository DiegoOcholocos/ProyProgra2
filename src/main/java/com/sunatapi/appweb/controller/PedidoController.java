package com.sunatapi.appweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.sunatapi.appweb.model.Cliente;
import com.sunatapi.appweb.model.DetallePedido;
import com.sunatapi.appweb.model.Pedido;
import com.sunatapi.appweb.model.Usuario;
import com.sunatapi.appweb.repository.ClienteRepository;
import com.sunatapi.appweb.repository.DetallePedidoRepository;
import com.sunatapi.appweb.repository.PedidoRepository;

import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
public class PedidoController {
 
    private static final String VIEW_INDEX ="pedido/index";
    private final PedidoRepository pedidoData;
    private final DetallePedidoRepository detallePedidoData;
    private final ClienteRepository clienteData;
    
    public PedidoController(PedidoRepository pedidoData,
        DetallePedidoRepository detallePedidoData,
        ClienteRepository clienteData
        ){
        this.pedidoData = pedidoData;
        this.detallePedidoData = detallePedidoData;
        this.clienteData = clienteData;
    }      

    @GetMapping("/pedido/index")
    public String index(Model model, HttpSession session){
        Usuario user = (Usuario)session.getAttribute("user"); 
        Cliente cliente = clienteData.findByUsuario(user);
        List<Pedido> listItems = pedidoData.findItemsByCliente(cliente.getId());
        model.addAttribute("pedidos",listItems);
        return VIEW_INDEX;
    }    

    @GetMapping("/pedido/view/{id}")
    public String createSubmitForm(@PathVariable("id") int id, 
            Model model ){
        Pedido pedido = pedidoData.getOne(id);
        List<DetallePedido> listItems = detallePedidoData.findItemsByPedido(pedido);
        model.addAttribute("detalles",listItems);
        return "pedido/detalle";
    }



}
