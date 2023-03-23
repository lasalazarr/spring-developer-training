package com.demo.springdata.repository;

import com.demo.springdata.model.Cliente;
import com.demo.springdata.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta,Integer> , JpaSpecificationExecutor<Cuenta> {
    List<Cuenta> findCuentaByEstadoIsTrue();
    void deleteAllByCliente_Id(int clienteId);
    List<Cuenta> findByCliente_IdAndEstadoIsTrue(int clienteId);

    //@Procedure(name = "getAllCuentas")
    //List<Cuenta> getAllCuentasSP();
}