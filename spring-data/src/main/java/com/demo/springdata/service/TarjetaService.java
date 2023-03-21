package com.demo.springdata.service;

import com.demo.springdata.model.Tarjeta;
import com.demo.springdata.repository.TarjetaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TarjetaService {
    private TarjetaRepository tarjetaRepository;

    public Tarjeta cambiarEstadoTarjetaPorId(int id, boolean estado){
        Tarjeta tarjeta = tarjetaRepository.findById(id)
                .orElseThrow(() -> {throw new RuntimeException("tarjetas de Cliente No Existe");});
        tarjeta.setEstado(estado);
        return tarjeta;
    }

    public List<Tarjeta> obtenerTarjetasPorIdCliente(int id){
        List<Tarjeta> resultado = tarjetaRepository.findByCliente_Id(id);
        return resultado;
    }
}