package com.eduardo.tarefas.domain.model;

import java.util.Objects;

public final class TarefaId {
	
	private final Long valor;

    public TarefaId(Long valor) {
        if (valor == null || valor <= 0) {
            throw new IllegalArgumentException("ID de tarefa inválido");
        }
        this.valor = valor;
    }

	public Long valor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TarefaId)) return false;
        TarefaId that = (TarefaId) o;
        return Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return valor.toString();
    }

}
