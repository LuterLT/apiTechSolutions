package br.com.techsolutionsglobal.tarefastechsolutions.controller;


import br.com.techsolutionsglobal.tarefastechsolutions.dto.TarefaResponseDTO;
import br.com.techsolutionsglobal.tarefastechsolutions.model.Tarefa;
import br.com.techsolutionsglobal.tarefastechsolutions.repository.TarefaRepository;
import br.com.techsolutionsglobal.tarefastechsolutions.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) { this.tarefaService = tarefaService; }

    // Listar todas tarefas --------------------------------
    @GetMapping
    public ResponseEntity<List<TarefaResponseDTO>> listarTarefas() { return ResponseEntity.ok(tarefaService.listarTudo());}

    // Buscar por ID ----------------------------------------
    @GetMapping("{id}")
    public ResponseEntity<TarefaResponseDTO> buscarTarefa(@PathVariable Long id) { return ResponseEntity.ok(tarefaService.buscarPorId(id));}
}
