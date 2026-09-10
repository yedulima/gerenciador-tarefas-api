package com.eduardo.tarefas.domain.repository;

import com.eduardo.tarefas.domain.model.Tarefa;
import com.eduardo.tarefas.domain.model.TarefaId;

import java.util.List;
import java.util.Optional;

public interface TarefaRepository {

    Tarefa salvar(Tarefa tarefa);

    Optional<Tarefa> buscarPorId(TarefaId id);

    List<Tarefa> listarTodas();

    void remover(TarefaId id);
}
