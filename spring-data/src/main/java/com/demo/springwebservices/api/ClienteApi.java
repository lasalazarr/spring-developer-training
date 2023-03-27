package com.demo.springwebservices.api;

import com.demo.springdata.dto.ClienteDto;
import com.demo.springdata.service.ClienteService;
import jakarta.validation.Valid;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/cliente")
@Slf4j
public class ClienteApi {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ClienteDto buscarCliente(@PathVariable int id){
        log.info("Busqueda de Cliente: {}", id);
        return clienteService.obtenerCliente(id);
    }

    @GetMapping(value = "/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ClienteDto buscarClienteXml(@PathVariable int id){
        log.info("Busqueda de Cliente: {}", id);
        return clienteService.obtenerCliente(id);
    }

    @GetMapping(value = "/xml/json/{id}", produces = {MediaType.APPLICATION_XML_VALUE
            , MediaType.APPLICATION_JSON_VALUE })
    public ClienteDto buscarClienteXmlJson(@PathVariable int id){
        log.info("Busqueda de Cliente: {}", id);
        return clienteService.obtenerCliente(id);
    }

    @GetMapping(value = "/parameter", produces = {MediaType.APPLICATION_XML_VALUE
            , MediaType.APPLICATION_JSON_VALUE })
    public ClienteDto buscarClienteParametro(@RequestParam int id){
        log.info("Busqueda de Cliente: {}", id);
        return clienteService.obtenerCliente(id);
    }

    @PostMapping
    public void guardarCliente(@Valid @RequestBody ClienteDto clienteDto){
        log.info("Cliente a crear: {}", clienteDto);
        clienteService.insertarCliente(clienteDto);
    }

    @GetMapping(value = "/all")
    public List<ClienteDto> obtenerTodosLosClientes(){
        log.info("Listar todos lo clientes");
        return clienteService.listarTodosLosClientes();
    }

    @PutMapping
    public void actualizarCliente(@RequestBody ClienteDto clienteDto){
        log.info("Actualizacion de Cliente : {}", clienteDto);
        clienteService.actualizarCliente(clienteDto);
    }

    @DeleteMapping(value = "/{id}")
    public  void eliminarCliente(@PathVariable int id){
        log.info("Eliminar cliente id {}", id);
        clienteService.eliminarCliente(id);
    }
}