package br.com.techsolutionsglobal.tarefastechsolutions.service;

import br.com.techsolutionsglobal.tarefastechsolutions.dto.TarefaCreateDTO;
import br.com.techsolutionsglobal.tarefastechsolutions.dto.TarefaResponseDTO;
import br.com.techsolutionsglobal.tarefastechsolutions.dto.TarefaUpdateDTO;
import br.com.techsolutionsglobal.tarefastechsolutions.model.Tarefa;
import br.com.techsolutionsglobal.tarefastechsolutions.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) { this.tarefaRepository = tarefaRepository; }

    // Criar Tarefa --------------------------------------------------
    public TarefaResponseDTO criar(TarefaCreateDTO dto) {
        Tarefa tarefa = new Tarefa(
                dto.titulo(),
                dto.descricao(),
                dto.prioridade()
                );

        tarefaRepository.save(tarefa);
        return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getPrioridade(),
                tarefa.getConcluida(),
                tarefa.getAtivo()
        );
    }

    // Listar Todas Tarefas -------------------------------------------
    public List<TarefaResponseDTO> listarTudo() {
        List<Tarefa> tarefaList = tarefaRepository.findAll();
        return  tarefaList.stream()
                .map(tarefa -> new TarefaResponseDTO(
                        tarefa.getId(),
                        tarefa.getTitulo(),
                        tarefa.getDescricao(),
                        tarefa.getPrioridade(),
                        tarefa.getConcluida(),
                        tarefa.getAtivo()
                ))
                .toList();
    }

    // Buscar Tarefa por ID ------------------------------------------
    public TarefaResponseDTO buscarPorId(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow();
        return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getPrioridade(),
                tarefa.getConcluida(),
                tarefa.getAtivo()
        );
    }

    // Atualizar Tarefa ------------------------------------------------
    public TarefaResponseDTO atualizar(Long id, TarefaUpdateDTO dto) {
        Tarefa tarefa = tarefaRepository.findById(id).orElseThrow();

            tarefa.setTitulo(dto.titulo());
            tarefa.setDescricao(dto.descricao());
            tarefa.setPrioridade(dto.prioridade());
            tarefa.setConcluida(dto.concluida());
            tarefa.setAtivo(dto.ativo());

            tarefaRepository.save(tarefa);


            return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getPrioridade(),
                tarefa.getConcluida(),
                tarefa.getAtivo()
        );
    }
}
