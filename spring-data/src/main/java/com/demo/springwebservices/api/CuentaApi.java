package com.demo.springwebservices.api;

import com.demo.springdata.dto.CuentaDto;
import com.demo.springdata.service.CuentaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/cuenta")
@Slf4j
public class CuentaApi {
    @Autowired
    CuentaService cuentaService;

    @PostMapping
    public void crearCuentaParaUnClientePorId(@RequestBody CuentaDto cuentaDto){
        log.info("Creado cuenta : {}", cuentaDto);
        cuentaService.creacionDeCuenta(cuentaDto);
    }

    @GetMapping(value = "/by-cliente/{idCliente}")
    public List<CuentaDto> obtenerCuentasDeUnCliente(@PathVariable int idCliente){
        log.info("Cuentas para un usuario{}", idCliente);
        return cuentaService.buscarCuentasPorCliente(idCliente);
    }

    @PostMapping(value = "/desactivar")
    public CuentaDto desactivarCuentaPorIdCuenta(@RequestBody CuentaDto cuentaDto){
        log.info("Desactivar Cuenta por:", cuentaDto);
        return cuentaService.desactivarCuentaPorId(cuentaDto);
    }
}
