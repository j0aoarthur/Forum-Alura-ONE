package br.com.alura.forum.controllers;

import br.com.alura.forum.topicos.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @GetMapping
    public Page<ListarTopicosDTO> listarTopicos(@PageableDefault(size = 10, sort = {"dataCriacao"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return repository.findAll(pageable).map(ListarTopicosDTO::new);
    }

    @GetMapping("/{id}")
    public ListarTopicosDTO detalharTopico(@PathVariable Long id) {
        return new ListarTopicosDTO(repository.getReferenceById(id));
    }

    @PostMapping
    @Transactional
    public void cadastrarTopico(@RequestBody @Valid DadosTopicoDTO dadosCadastro) {
        repository.save(new Topico(dadosCadastro));
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizarTopico(@PathVariable Long id, @RequestBody DadosTopicoDTO dadosAtualizacao) {
        Topico topico = repository.getReferenceById(id);
        topico.atualizarInformacoes(dadosAtualizacao);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarTopico(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
