CREATE TABLE forum_alura.topicos (
    id BIGINT AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL UNIQUE,
    mensagem VARCHAR(255) NOT NULL UNIQUE,
    data_criacao TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    autor VARCHAR(50) NOT NULL,
    curso VARCHAR(50) NOT NULL,

    PRIMARY KEY (id)
)