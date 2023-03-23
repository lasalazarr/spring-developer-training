package com.demo.springbeans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdministradorClientesScopeTest {

    @Autowired
    @Qualifier("defaultNombres")
    private AdministradorClientes singleton1;

    @Autowired
    @Qualifier("defaultNombres")
    private AdministradorClientes singleton2;
    @Autowired
    @Qualifier("defaultNombresPrototype")
    private AdministradorClientes prototype1;
    @Autowired
    @Qualifier("defaultNombresPrototype")
    private AdministradorClientes prototype2;
    @Autowired
    @Qualifier("defaultNombresPrototype")
    private AdministradorClientes prototype3;

    @Autowired
    @Qualifier("defaultNombres")
    private AdministradorClientes singleton3;

    @Autowired
    @Qualifier("defaultNombresRequest")
    private AdministradorClientes requestInstance;

    @Test
    void instancias() {
        System.out.println("singleton1 " + singleton1);
        System.out.println("singleton2 " + singleton2);
        System.out.println("prototype1 " + prototype1);
        System.out.println("prototype2 " + prototype2);
        System.out.println("prototype3 " + prototype3);
        System.out.println("singleton3 " + singleton3);
        System.out.println("requestInstance " + requestInstance);

        Assertions.assertEquals(1, 1);
    }
}