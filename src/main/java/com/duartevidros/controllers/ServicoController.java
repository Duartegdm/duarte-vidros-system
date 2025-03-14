package com.duartevidros.controllers;

import com.duartevidros.services.ServicoService;
import com.duartevidros.models.Servico;
import com.duartevidros.models.StatusModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicos")
public class ServicoController {
    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<Servico> getAllServicos() {
        return servicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Servico> getServicoById(@PathVariable Long id) {
        return servicoService.buscarPorId(id);
    }

    @PostMapping
    public Servico createServico(@RequestBody Servico servico) {
        return servicoService.salvarServico(servico);
    }

    @PutMapping("/{id}")
    public Servico updateServico(@PathVariable Long id, @RequestBody Servico servico) {
        return servicoService.atualizarServico(id, servico);
    }

    @DeleteMapping("/{id}")
    public void deleteServico(@PathVariable Long id) {
        servicoService.deletarServico(id);
    }

    @PutMapping("/{id}/status")
    public Servico updateServicoStatus(@PathVariable Long id, @RequestBody StatusModel status) {
        return servicoService.atualizarStatusServico(id, status);
    }
}