package com.demo.springdata.service;

import com.demo.springdata.dto.CuentaDto;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CuentaServiceTest {

    @Autowired
    private CuentaService cuentaService;

    @Test
    void buscarCuentasDinamicamentePorCriterio() {
        CuentaDto cuentaDto = new CuentaDto();
        //cuentaDto.setTipo("AHORROS");
        cuentaDto.setEstado(true);
         cuentaService.buscarCuentasDinamicamentePorCriterio(cuentaDto).forEach(
                cuentaDtoResultado -> {System.out.println("Cuenta Resultado" + cuentaDtoResultado);});
        assertEquals(1,1);
    }

    @Test
    void creacionDeCuenta() {
        CuentaDto cuentaDto = new CuentaDto();
        cuentaDto.setNumero("");
        cuentaDto.setTipo("MASTERCARD");
        cuentaDto.setEstado(true);
        cuentaDto.setIdCliente(1);
        cuentaService.creacionDeCuenta(cuentaDto);
        assertEquals(1,1);
    }
}