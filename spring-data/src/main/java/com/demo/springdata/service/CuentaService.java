package com.demo.springdata.service;

import com.demo.springdata.repository.CuentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CuentaService {
    private CuentaRepository cuentaRepository;
}
