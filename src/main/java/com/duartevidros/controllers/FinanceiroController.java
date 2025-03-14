package com.duartevidros.controllers;

import com.duartevidros.services.FinanceiroService;
import com.duartevidros.models.Financeiro;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/financeiro")
public class FinanceiroController {
    @Autowired
    private FinanceiroService financeiroService;

    @GetMapping
    public List<Financeiro> getAllFinanceiro() {
        return financeiroService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Financeiro> getFinanceiroById(@PathVariable Long id) {
        return financeiroService.buscarPorId(id);
    }

    @PostMapping
    public Financeiro createFinanceiro(@RequestBody Financeiro financeiro) {
        return financeiroService.salvarFinanceiro(financeiro);
    }

    @PutMapping("/{id}")
    public Financeiro updateFinanceiro(@PathVariable Long id, @RequestBody Financeiro financeiro) {
        return financeiroService.atualizarFinanceiro(id, financeiro);
    }

    @DeleteMapping("/{id}")
    public void deleteFinanceiro(@PathVariable Long id) {
        financeiroService.deletarFinanceiro(id);
    }
}