package com.demo.springbeans.config;

import com.demo.springbeans.AdministradorClientes;
import com.demo.springbeans.dto.ClienteQueryType;
import com.demo.springdata.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class BeanConfiguration {

    @Autowired
    private ClienteRepository clienteRepository;

    @Bean({"defaultCedula", "criteriaByCedula"})//Si tiene mas de un nombre para usarlo
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public AdministradorClientes administradorClientesBean() {
        //Puede tener lógica adicional si es necesario
        //Se devuelve la instancia del objeto que se desea exponer como Bean
        return new AdministradorClientes(clienteRepository, ClienteQueryType.CEDULA);
    }

    @Bean("defaultNombres") //Si se un nombre va de esta manera
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public AdministradorClientes administradorClientesByNombre() {
        return new AdministradorClientes(clienteRepository,ClienteQueryType.NOMBRES);
    }

    @Bean("defaultNombresPrototype") //Si se un nombre va de esta manera
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Lazy
    public AdministradorClientes administradorClientesPrototype() {
        //Puede tener lógica adicional si es necesario
        //Se devuelve la instacia del objeto que se desea exponer como Bean
        return new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
    }

    @Bean("defaultNombresRequest") //Si se un nombre va de esta manera
    @RequestScope
    @Lazy
    public AdministradorClientes administradorClientesRequest() {
        //Puede tener lógica adicional si es necesario
        //Se devuelve la instacia del objeto que se desea exponer como Bean
        return new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
    }

    @Bean("defaultNombresSession") //Si se un nombre va de esta manera
    @SessionScope
    @Lazy
    public AdministradorClientes administradorClientesSession() {
        //Puede tener lógica adicional si es necesario
        //Se devuelve la instacia del objeto que se desea exponer como Bean
        return new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
    }

    @Bean("defaultNombresApplication") //Si se un nombre va de esta manera
    @ApplicationScope
    @Lazy
    public AdministradorClientes administradorClientesApplication() {
        //Puede tener lógica adicional si es necesario
        //Se devuelve la instacia del objeto que se desea exponer como Bean
        return new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
    }
}
