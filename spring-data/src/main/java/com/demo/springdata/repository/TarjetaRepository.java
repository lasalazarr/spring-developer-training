package com.demo.springdata.repository;

import com.demo.springdata.model.Cuenta;
import com.demo.springdata.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {
    List<Tarjeta> findByCliente_Id(int clienteId);

}
