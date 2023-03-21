package com.demo.springdata.service;

import com.demo.springdata.model.Tarjeta;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TarjetaServiceTest {

    @Autowired
    TarjetaService tarjetaService;
    @Test
    void cambiarEstadoTarjetaPorId() {
        //inactivar con estado en false
        Tarjeta tarjeta = tarjetaService.cambiarEstadoTarjetaPorId(1, false);
        assertEquals(false,tarjeta.getEstado());
    }

    @Test
    void obtenerTarjetasPorIdCliente() {
        tarjetaService.obtenerTarjetasPorIdCliente(1)
                .forEach(tarjeta -> {
                    System.out.println("Tarjetas:" + tarjeta.getNumero() + " Estado" + tarjeta.getEstado());
                        });
    }
}