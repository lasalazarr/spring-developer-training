package com.demo.springdata.repository;

import com.demo.springdata.model.Cliente;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>, JpaSpecificationExecutor<Cliente> {
     //Metodo de consulta derived
     List<Cliente> findClientesByPaisNacimientoAndCuentas_EstadoIsTrue(String paisNacimiento);
     // jpaql
     @Query(value = "select c from Cliente c where c.apellidos = :apellidos")
     List<Cliente> buscarPorApellidos(String apellidos);

     @Query(value = "select nombre,apellidos,cedula,telefono,id from cliente where apellidos = :apellidos",
             nativeQuery = true)
     List<Tuple>  buscarPorApellidosNativo(String apellidos);

     //List<Cliente> findClientesByPaisNacimientoContainsAndTarjeta_EstadoIsTrue();
}