CREATE TABLE IF NOT EXISTS tarefa (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    concluida BOOLEAN NOT NULL DEFAULT FALSE,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX IF NOT EXISTS idx_tarefa_concluida ON tarefa (concluida);

INSERT INTO tarefa (titulo, descricao, concluida) VALUES
    ('Estudar Quarkus', 'Revisar conceitos de REST Client e DDD', FALSE),
    ('Configurar Docker Compose', 'Subir Postgres e Quarkus em containers', TRUE),
    ('Criar testes unitários', 'Cobrir casos de uso da API de tarefas', FALSE);
