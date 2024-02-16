package br.com.alura.forum.topicos;

import java.time.LocalDateTime;

public record ListarTopicosDTO(String titulo, String mensagem, LocalDateTime dataCriacao, StatusTopico status, String autor, String curso) {

    public ListarTopicosDTO(Topico topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
