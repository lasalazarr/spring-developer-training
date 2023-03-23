package com.demo.springdata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@NamedStoredProcedureQueries({
//        @NamedStoredProcedureQuery(name = "getAllClientes", procedureName = "get_all_clientes",
//                resultClasses = Cliente.class) })
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numero;
    private String tipo;
    private Boolean estado; // activo/desactivo
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;
}
