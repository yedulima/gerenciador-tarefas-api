package com.eduardo.tarefas.domain.model;

import java.time.LocalDateTime;

import com.eduardo.tarefas.domain.exception.TarefaJaConcluidaException;
import com.eduardo.tarefas.domain.exception.TituloInvalidoException;

public class Tarefa {
	
	private TarefaId id;
	private String titulo;
	private String descricao;
	private boolean concluida;
	private final LocalDateTime dataCriacao;

	public Tarefa(String titulo, String descricao) {
		if (titulo == null || titulo.isBlank()) {
			throw new TituloInvalidoException("Título deve ser informado.");
		}

		this.titulo = titulo;
		this.descricao = descricao;
		this.concluida = false;
		this.dataCriacao = LocalDateTime.now();
	}

	public Tarefa(TarefaId id, String titulo, String descricao, boolean concluida, LocalDateTime dataCriacao) {
		if (titulo == null || titulo.isBlank()) {
			throw new TituloInvalidoException("Título deve ser informado.");
		}

		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.concluida = concluida;
		this.dataCriacao = dataCriacao;
	}

	public void atualizar(String titulo, String descricao) {
        if (titulo == null || titulo.isBlank()) {
			throw new TituloInvalidoException("Título deve ser informado.");
		}
		
        this.titulo = titulo;
        this.descricao = descricao;
    }

	public void concluir() {
		if (this.concluida) {
			throw new TarefaJaConcluidaException("Tarefa já está concluída.");
		}
		this.concluida = true;
	}

	public TarefaId getId() { return this.id; }
	public String getTitulo() { return this.titulo; }
	public String getDescricao() { return this.descricao; }
	public boolean isConcluida() { return this.concluida; }
	public LocalDateTime getDataCriacao() { return this.dataCriacao; }

	public void setId(TarefaId id) {
		this.id = id;
	}

}
