package com.eduardo.tarefas.domain.exception;

public class TarefaJaConcluidaException extends RuntimeException {
	
	public TarefaJaConcluidaException(String mensagem) {
        super(mensagem);
    }

}
