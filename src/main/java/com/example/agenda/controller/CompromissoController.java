package com.example.agenda.controller;

import com.example.agenda.model.CompromissoModel;
import com.example.agenda.service.CompromissoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compromissos")
public class CompromissoController {

    private final CompromissoService compromissoService;

    public CompromissoController(CompromissoService compromissoService) {
        this.compromissoService = compromissoService;
    }

    @GetMapping
    public List<CompromissoModel> listarCompromissos() {
        return compromissoService.listarCompromissos();
    }

    @PostMapping
    public CompromissoModel criarCompromisso(CompromissoModel compromissoModel) {
        return compromissoService.criarCompromisso(compromissoModel);
    }

    @PatchMapping("/titulo")
    public CompromissoModel alterarTituloCompromisso(String compromissoId, String novoTitulo) {
        return compromissoService.alterarTituloCompromisso(compromissoId, novoTitulo);
    }

    @PatchMapping("/descricao")
    public CompromissoModel alterarDescricaoCompromisso(String compromissoId, String novaDescricao) {

        return compromissoService.alterarDescricaoCompromisso(compromissoId, novaDescricao);
    }

    @PatchMapping("/pessoa")
    public CompromissoModel alterarPessoasCompromisso(String compromissoId, String nomePessoa) {

        return compromissoService.alterarPessoasCompromisso(compromissoId, nomePessoa);
    }

    @PatchMapping("/remove-pessoa")
    public CompromissoModel excluirPessoaDoCompromisso(String compromissoId, String nomePessoa) {

        return compromissoService.excluirPessoaDoCompromisso(compromissoId, nomePessoa);
    }

    @DeleteMapping
    public void excluirCompromisso(String compromissoId) {
        compromissoService.excluirCompromisso(compromissoId);
    }
}
