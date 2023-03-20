package com.demo.springdata.service;

import com.demo.springdata.dto.ClienteDto;
import com.demo.springdata.model.Cliente;
import com.demo.springdata.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;

    public void insertarCliente(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setApellidos(clienteDto.getApellido());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setCedula(clienteDto.getCedula());
        cliente.setTelefono(clienteDto.getTelefono());
        clienteRepository.save(cliente);
    }

    public ClienteDto obtenerCliente(int idCliente){
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> {throw new RuntimeException("Cliente No Existe");});
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(cliente.getId());
        clienteDto.setApellido(cliente.getApellidos());
        clienteDto.setNombre(cliente.getNombre());
        clienteDto.setCedula(cliente.getCedula());
        return clienteDto;
    }

    public void actualizarCliente(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setId(clienteDto.getId());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellidos(clienteDto.getApellido());
        cliente.setCedula(clienteDto.getCedula());
        cliente.setTelefono(clienteDto.getTelefono());
        clienteRepository.save(cliente);
    }

    public void eliminarCliente(Integer clienteId){
        clienteRepository.deleteById(clienteId);
    }
}