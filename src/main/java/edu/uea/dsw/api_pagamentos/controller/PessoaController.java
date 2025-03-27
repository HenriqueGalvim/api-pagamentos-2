package edu.uea.dsw.api_pagamentos.controller;

import java.net.URI;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.uea.dsw.api_pagamentos.dto.PessoaDTO;
import edu.uea.dsw.api_pagamentos.service.PessoaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    // GET /pessoas
    @GetMapping
    public List<PessoaDTO> listarPessoas() {
        return pessoaService.listarPessoas();
    }

    // GET /pessoas/{codigo}
    @GetMapping("/{codigo}")
    public PessoaDTO buscarPessoa(@PathVariable Long codigo) {
        return pessoaService.buscarPessoaPorCodigo(codigo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<PessoaDTO> atualizarPessoa(@Valid @PathVariable Long codigo, @RequestBody PessoaDTO pessoa) {
        PessoaDTO atualizada = pessoaService.atualizarPessoa(codigo, pessoa);
        return ResponseEntity.ok(atualizada);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> criarPessoa(@Valid @RequestBody PessoaDTO pessoa) {
        PessoaDTO criada = pessoaService.criarPessoa(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{codigo}")
                .buildAndExpand(criada.getCodigo())
                .toUri();
        return ResponseEntity.created(uri).body(criada);
    }

    // DELETE /pessoas/{codigo}
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long codigo) {
        pessoaService.deletarPessoa(codigo);
        return ResponseEntity.noContent().build();
    }

    // PATCH /pessoas/{codigo}/ativo
    @PatchMapping("/{codigo}/ativo")
    public PessoaDTO atualizarStatus(@PathVariable Long codigo, @RequestBody Boolean ativo) {
        return pessoaService.atualizarStatus(codigo, ativo);
    }
}
