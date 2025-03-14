package com.duartevidros.services;

import com.duartevidros.models.Financeiro;
import com.duartevidros.repository.FinanceiroRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class FinanceiroService {
    @Autowired
    private FinanceiroRepository financeiroRepository;

    public Financeiro salvarFinanceiro(Financeiro financeiro) {
        return financeiroRepository.save(financeiro);
    }

    public List<Financeiro> listarTodos() {
        return financeiroRepository.findAll();
    }

    public Optional<Financeiro> buscarPorId(Long id) {
        return financeiroRepository.findById(id);
    }

    public Financeiro atualizarFinanceiro(Long id, Financeiro novoFinanceiro) {
        if (financeiroRepository.existsById(id)) {
            novoFinanceiro.setId(id);
            return financeiroRepository.save(novoFinanceiro);
        }
        return null;
    }

    public void deletarFinanceiro(Long id) {
        financeiroRepository.deleteById(id);
    }
}
