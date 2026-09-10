package com.eduardo.tarefas.infrastructure.persistence;

import com.eduardo.tarefas.domain.model.Tarefa;
import com.eduardo.tarefas.domain.model.TarefaId;
import com.eduardo.tarefas.domain.repository.TarefaRepository;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TarefaRepositoryImpl implements TarefaRepository {
	
	@Override
    public Tarefa salvar(Tarefa tarefa) {
        TarefaEntity entity;

        if (tarefa.getId() == null) {
            entity = new TarefaEntity();
        } else {
            entity = TarefaEntity.findById(tarefa.getId().valor());
        }

        entity.titulo = tarefa.getTitulo();
        entity.descricao = tarefa.getDescricao();
        entity.concluida = tarefa.isConcluida();
        entity.dataCriacao = tarefa.getDataCriacao();

        if (tarefa.getId() == null) {
            entity.persist();
        }

        tarefa.setId(new TarefaId(entity.id));
        return tarefa;
    }

    @Override
    public Optional<Tarefa> buscarPorId(TarefaId id) {
        TarefaEntity entity = TarefaEntity.findById(id.valor());
        if (entity == null) {
            return Optional.empty();
        }
        return Optional.of(paraDomain(entity));
    }

    @Override
    public List<Tarefa> listarTodas() {
        return TarefaEntity.<TarefaEntity>listAll()
            .stream()
            .map(this::paraDomain)
            .toList();
    }

    @Override
    public void remover(TarefaId id) {
        TarefaEntity.deleteById(id.valor());
    }

    private Tarefa paraDomain(TarefaEntity entity) {
        return new Tarefa(
            new TarefaId(entity.id),
            entity.titulo,
            entity.descricao,
            entity.concluida,
            entity.dataCriacao
        );
    }

}
