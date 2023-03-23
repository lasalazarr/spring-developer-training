package com.demo.springdata.repository;

import com.demo.springdata.model.Cuenta;
import com.demo.springdata.model.Inversion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InversionRepository extends JpaRepository<Inversion, Integer> {
    List<Inversion> findByCliente_IdAndEstadoIsTrue(int clienteId);
}
