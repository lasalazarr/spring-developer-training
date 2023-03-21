package com.demo.springdata.api;

import com.demo.springdata.dto.ClienteDto;
import com.demo.springdata.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
@Slf4j
public class DemoApi {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/client/{id}")
    public ClienteDto buscarCliente(@PathVariable int id){
        log.info("Busqueda de cliente : {}", id);
        return clienteService.obtenerCliente(id);
    }
}
