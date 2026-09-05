package br.com.techsolutionsglobal.tarefastechsolutions.controller;


import br.com.techsolutionsglobal.tarefastechsolutions.dto.TarefaCreateDTO;
import br.com.techsolutionsglobal.tarefastechsolutions.dto.TarefaResponseDTO;
import br.com.techsolutionsglobal.tarefastechsolutions.dto.TarefaUpdateDTO;
import br.com.techsolutionsglobal.tarefastechsolutions.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> buscarTarefa(@PathVariable Long id) { return ResponseEntity.ok(tarefaService.buscarPorId(id));}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerTarefa(@PathVariable Long id) {
        boolean removida = tarefaService.deletar(id);

        return removida
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    // Criar Tarefa -----------------------------------------
    @PostMapping
    public  ResponseEntity<TarefaResponseDTO> adicionarTarefa(@RequestBody TarefaCreateDTO tarefaCreate) {
        TarefaResponseDTO tarefaResponse = tarefaService.criar(tarefaCreate);
        return ResponseEntity.status(201).body(tarefaResponse);
    }

    // Atualizar Tarefa ---------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizarTarefa(
            @PathVariable Long id,
            @RequestBody TarefaUpdateDTO tarefaUpdate) {

        TarefaResponseDTO tarefaResponse = tarefaService.atualizar(id, tarefaUpdate);
        return ResponseEntity.ok(tarefaResponse);
    }
}
