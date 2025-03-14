package com.duartevidros.controllers;

import com.duartevidros.services.DistribuidoraService;
import com.duartevidros.models.Distribuidora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/distribuidoras")
public class DistribuidoraController {
    @Autowired
    private DistribuidoraService distribuidoraService;

    @GetMapping
    public List<Distribuidora> getAllDistribuidoras() {
        return distribuidoraService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Distribuidora> getDistribuidoraById(@PathVariable Long id) {
        return distribuidoraService.buscarPorId(id);
    }

    @PostMapping
    public Distribuidora createDistribuidora(@RequestBody Distribuidora distribuidora) {
        return distribuidoraService.salvarDistribuidora(distribuidora);
    }

    @PutMapping("/{id}")
    public Distribuidora updateDistribuidora(@PathVariable Long id, @RequestBody Distribuidora distribuidora) {
        return distribuidoraService.atualizarDistribuidora(id, distribuidora);
    }

    @DeleteMapping("/{id}")
    public void deleteDistribuidora(@PathVariable Long id) {
        distribuidoraService.deletarDistribuidora(id);
    }
}

