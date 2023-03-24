package com.demo.springdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CuentaDto {
    private int id;
    private String numero;
    private String tipo;
    private Boolean estado;
    private int idCliente;
}
