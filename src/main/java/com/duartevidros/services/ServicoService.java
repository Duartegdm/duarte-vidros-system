package com.duartevidros.services;

import com.duartevidros.models.Servico;
import com.duartevidros.models.StatusModel;
import com.duartevidros.repository.ServicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;

    public Servico salvarServico(Servico servico) {
        return servicoRepository.save(servico);
    }

    public List<Servico> listarTodos() {
        return servicoRepository.findAll();
    }

    public Optional<Servico> buscarPorId(Long id) {
        return servicoRepository.findById(id);
    }

    public Servico atualizarServico(Long id, Servico novoServico) {
        if (servicoRepository.existsById(id)) {
            novoServico.setId(id);
            return servicoRepository.save(novoServico);
        }
        return null;
    }

    public void deletarServico(Long id) {
        servicoRepository.deleteById(id);
    }

    public Servico atualizarStatusServico(Long id, StatusModel status) {
        Optional<Servico> optionalServico = servicoRepository.findById(id);
        if (optionalServico.isPresent()) {
            Servico servico = optionalServico.get();
            servico.setStatus(status);
            return servicoRepository.save(servico);
        } else {
            throw new EntityNotFoundException("Serviço não encontrado com o ID: " + id);
        }
    }

}
