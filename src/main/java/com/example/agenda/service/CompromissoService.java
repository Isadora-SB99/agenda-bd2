package com.example.agenda.service;

import com.example.agenda.model.CompromissoModel;
import com.example.agenda.repository.CompromissoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompromissoService {

    private CompromissoRepository compromissoRepository;

    public List<CompromissoModel> listarCompromissos(){
        return compromissoRepository.findAll();
    }

    public CompromissoModel criarCompromisso(CompromissoModel compromissoModel) {
        return compromissoRepository.save(compromissoModel);
    }

    public CompromissoModel alterarTituloCompromisso(String compromissoId, String novoTitulo) {
        CompromissoModel compromisso = compromissoRepository.findById(compromissoId).get();
        compromisso.setTitulo(novoTitulo);
        return compromissoRepository.save(compromisso);
    }

    public CompromissoModel alterarDescricaoCompromisso(String compromissoId, String novaDescricao) {
        CompromissoModel compromisso = compromissoRepository.findById(compromissoId).get();
        compromisso.setDescricao(novaDescricao);
        return compromissoRepository.save(compromisso);
    }

    public CompromissoModel alterarPessoasCompromisso(String compromissoId, String nomePessoa) {
        CompromissoModel compromisso = compromissoRepository.findById(compromissoId).get();

        compromisso.getPessoasEnvolvidas().add(nomePessoa);
        return compromissoRepository.save(compromisso);
    }

    public CompromissoModel excluirPessoaDoCompromisso(String compromissoId, String nomePessoa) {
        CompromissoModel compromisso = compromissoRepository.findById(compromissoId).get();

        compromisso.getPessoasEnvolvidas().remove(nomePessoa);
        return compromissoRepository.save(compromisso);
    }

    public void excluirCompromisso(String compromissoId) {
        compromissoRepository.deleteById(compromissoId);
    }
}
