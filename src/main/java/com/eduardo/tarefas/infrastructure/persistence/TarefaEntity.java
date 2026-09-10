package com.eduardo.tarefas.infrastructure.persistence;

import java.time.LocalDateTime;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarefa")
public class TarefaEntity extends PanacheEntity {

	@Column(nullable = false)
	public String titulo;

	public String descricao;

    @Column(nullable = false)
    public boolean concluida;

    @Column(name = "data_criacao", nullable = false)
    public LocalDateTime dataCriacao;

}
