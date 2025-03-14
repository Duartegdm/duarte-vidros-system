package com.duartevidros.services;


import com.duartevidros.models.Cliente;
import com.duartevidros.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente atualizarCliente(Long id, Cliente novoCliente) {
        if (clienteRepository.existsById(id)) {
            novoCliente.setId(id);
            return clienteRepository.save(novoCliente);
        }
        return null;
    }

    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
