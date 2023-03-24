package com.demo.springdata.service;

import com.demo.springdata.dto.ClienteDto;
import com.demo.springdata.dto.ProductosDto;
import com.demo.springdata.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    void insertarCliente() {
        List<Cliente> clienteList = entityManager.createQuery("SELECT c FROM Cliente c").getResultList();
        System.out.println("listar antes de insertar: " + clienteList);
        System.out.println("listar cuantos tiene: " + clienteList.size());
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setApellidos("Salazar");
        clienteDto.setNombre(null);
        clienteDto.setCedula("1890000000");
        clienteDto.setTelefono("0999714563");
        clienteDto.setDireccionsDto(null);
        clienteService.insertarCliente(clienteDto);

        clienteList = entityManager.createQuery("SELECT c FROM Cliente c").getResultList();
        assertFalse(clienteList.isEmpty());
        System.out.println("listar cuantos tiene: " + clienteList.size());
        assertEquals("1890000000", clienteList.get(5).getCedula());
    }

    @Test
    void insertarClienteConValidaciones(){
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setApellidos("Salazar");
        clienteDto.setNombre(null);
        clienteDto.setCedula("1890000000");
        clienteDto.setTelefono("0999714563");
        clienteDto.setDireccionsDto(null);
        clienteService.insertarCliente(clienteDto);
        assertEquals(1,1);
    }

    @Test
    void obtenerCliente() {
        ClienteDto clienteDto = clienteService.obtenerCliente(1);
        System.out.println("El cliente es:" + clienteDto.getNombre() + clienteDto.getApellidos());
        assertEquals(1, clienteDto.getId());
    }

    @Test
    void actualizarCliente() {
        //INSERT INTO CLIENTE (APELLIDOS, CEDULA, NOMBRE, TELEFONO) VALUES ('PEREZ', '1', 'ROBERTO', '093939393');
        ClienteDto clienteDtoBase = clienteService.obtenerCliente(1);
        System.out.println(clienteDtoBase);

        clienteDtoBase.setNombre(clienteDtoBase.getNombre() + "TEST");
        clienteDtoBase.setCedula(clienteDtoBase.getCedula() + "TEST");
        clienteDtoBase.setTelefono(clienteDtoBase.getTelefono() + "TEST");
        clienteDtoBase.setApellidos(clienteDtoBase.getApellidos() + "TEST");
        clienteService.actualizarCliente(clienteDtoBase);

        ClienteDto clienteDtoBaseUpdated = clienteService.obtenerCliente(1);

        System.out.println(clienteDtoBaseUpdated);
        assertEquals("ROBERTOTEST", clienteDtoBaseUpdated.getNombre());
        assertEquals("PEREZTEST", clienteDtoBaseUpdated.getApellidos());
    }

    @Test
    void eliminarCliente() {
        ClienteDto clienteDtoBase = clienteService.obtenerCliente(1);
        assertEquals(1, clienteDtoBase.getId());
        clienteDtoBase.getDireccionsDto().stream().map(
                direccionDto ->{
                    System.out.println(direccionDto.getDireccion());
                    return direccionDto;
                });
        clienteService.eliminarCliente(1);

        try {
            clienteService.obtenerCliente(1);
            fail("No debe llegar aca");
        } catch (RuntimeException e) {
            System.out.println("CLIENTE NO EXISTE: " + e.getMessage());
        }
    }

    @Test
    void obtenerClientesPorCodigoISOPaisYCuentasActivas() {
        List<ClienteDto> clientesDto = clienteService.obtenerClientesPorCodigoISOPaisYCuentasActivas("CR");
        clientesDto.forEach(clienteDto -> {System.out.println("Cuentas Activas" + clienteDto);});
        assertEquals(1, clientesDto.size());
    }

    @Test
    void buscarClientesPorApellido() {
        List<Cliente> cliente =  clienteService.buscarClientesPorApellido("PEREZ");
        assertFalse(cliente.isEmpty());
        assertEquals("PEREZ", cliente.get(0).getApellidos());
    }

    @Test
    void buscarClientesPorApellidoNativo() {
        clienteService.buscarClientesPorApellidoNativo("PEREZ");
        assertEquals(1,1);
    }

    @Test
    void buscarClientesDinamicamentePorCriterio() {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setApellidos("SANCHEZ");
        clienteDto.setNombre("RAUL");
        List<ClienteDto> resultadoCriteriosConDatosDTO = clienteService.buscarClientesDinamicamentePorCriterio(clienteDto);
        resultadoCriteriosConDatosDTO.forEach(clienteDtoResultado -> {System.out.println("ClienteDto es:"+ clienteDtoResultado);});
        assertEquals(1,resultadoCriteriosConDatosDTO.size());
    }

    @Test
    void obtenerTodosLosProductosDeUnCliente() {
        ProductosDto productosDto = clienteService.obtenerTodosLosProductosDeUnCliente(1);
        assertEquals(2, productosDto.getCuentaDto().size());
    }
}