package br.com.alura.forum.topicos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = {"titulo", "mensagem"})
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String titulo;

    @NotBlank
    @Column(unique = true)
    private String mensagem;

    @NotNull
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

    @NotBlank
    private String autor;

    @NotBlank
    private String curso;

    public Topico(DadosTopicoDTO dadosCadastro) {
        this.titulo = dadosCadastro.titulo();
        this.mensagem = dadosCadastro.mensagem();
        this.autor = dadosCadastro.autor();
        this.curso = dadosCadastro.curso();
        this.dataCriacao = LocalDateTime.now();
    }

    public void atualizarInformacoes(DadosTopicoDTO dadosAtualizacao) {
        if (dadosAtualizacao.titulo() != null) this.titulo = dadosAtualizacao.titulo();
        if (dadosAtualizacao.mensagem() != null) this.mensagem = dadosAtualizacao.mensagem();
        if (dadosAtualizacao.autor() != null) this.autor = dadosAtualizacao.autor();
        if (dadosAtualizacao.curso() != null) this.curso = dadosAtualizacao.curso();
    }
}
