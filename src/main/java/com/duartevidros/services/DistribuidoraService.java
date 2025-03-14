package com.duartevidros.services;

import com.duartevidros.models.Distribuidora;
import com.duartevidros.repository.DistribuidoraRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;

@Service
public class DistribuidoraService {

    @Autowired
    private DistribuidoraRepository distribuidoraRepository;

    public Distribuidora salvarDistribuidora(Distribuidora distribuidora) {
        return distribuidoraRepository.save(distribuidora);
    }

    public List<Distribuidora> listarTodos() {
        return distribuidoraRepository.findAll();
    }

    public Optional<Distribuidora> buscarPorId(Long id) {
        return distribuidoraRepository.findById(id);
    }

    public Distribuidora atualizarDistribuidora(Long id, Distribuidora novaDistribuidora) {
        if(distribuidoraRepository.existsById(id)) {
            novaDistribuidora.setId(id);
            distribuidoraRepository.save(novaDistribuidora);
        }
        return null;
    }

    public void deletarDistribuidora(Long id) {
        distribuidoraRepository.deleteById(id);
    }
}
