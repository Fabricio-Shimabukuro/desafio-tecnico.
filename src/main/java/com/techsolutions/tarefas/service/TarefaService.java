package com.techsolutions.tarefas.service;

import com.techsolutions.tarefas.model.Tarefa;
import com.techsolutions.tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa criar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> buscarPorId(Long id) {
        return tarefaRepository.findById(id);
    }

    public Optional<Tarefa> atualizar(Long id, Tarefa novosDados) {
        Optional<Tarefa> tarefaExistente = tarefaRepository.findById(id);

        if (tarefaExistente.isPresent()) {
            Tarefa tarefa = tarefaExistente.get();
            tarefa.setTitulo(novosDados.getTitulo());
            tarefa.setDescricao(novosDados.getDescricao());
            tarefa.setPrioridade(novosDados.getPrioridade());

            return Optional.of(tarefaRepository.save(tarefa));
        }

        return Optional.empty();
    }

    public boolean remover(Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);

        if (tarefa.isPresent()) {
            tarefaRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
