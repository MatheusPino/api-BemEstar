package com.fiap.bemestar.api.controller;

import com.fiap.bemestar.api.model.Tip;
import com.fiap.bemestar.api.repository.TipRepository;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tips")
public class TipController {

    private final TipRepository repo;

    public TipController(TipRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Tip> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Tip create(@RequestBody Tip tip) {
        // Gera o próximo ID sequencial
        tip.setId(generateNextId());
        tip.setCreatedAt(Instant.now());
        return repo.save(tip);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        repo.deleteById(id);
    }

    // Método para gerar o próximo ID no formato 0000, 0001, 0002...
    private String generateNextId() {
        Tip lastTip = repo.findTopByOrderByIdDesc();

        if (lastTip == null || lastTip.getId() == null) {
            return "0000"; // Primeiro ID
        }

        try {
            int lastId = Integer.parseInt(lastTip.getId());
            int nextId = lastId + 1;
            return String.format("%04d", nextId); // Formata com 4 dígitos: 0001, 0002, etc.
        } catch (NumberFormatException e) {
            return "0000"; // Se houver erro na conversão, começa do 0000
        }
    }
}