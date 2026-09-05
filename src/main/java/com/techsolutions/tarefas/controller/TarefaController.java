package com.techsolutions.tarefas.controller;

import com.techsolutions.tarefas.model.Tarefa;
import com.techsolutions.tarefas.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa tarefa) {
        Tarefa tarefaCriada = tarefaService.criar(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaCriada);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTodas() {
        return ResponseEntity.ok(tarefaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaService.buscarPorId(id);

        if (tarefa.isPresent()) {
            return ResponseEntity.ok(tarefa.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(
            @PathVariable Long id,
            @RequestBody Tarefa novosDados) {

        Optional<Tarefa> tarefaAtualizada =
                tarefaService.atualizar(id, novosDados);

        if (tarefaAtualizada.isPresent()) {
            return ResponseEntity.ok(tarefaAtualizada.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (tarefaService.remover(id)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
