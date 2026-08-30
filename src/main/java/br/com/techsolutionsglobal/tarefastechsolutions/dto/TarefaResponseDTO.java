package br.com.techsolutionsglobal.tarefastechsolutions.dto;

public record TarefaResponseDTO(
        Long id,
        String titulo,
        String descricao,
        int prioridade,
        boolean concluida,
        boolean ativo
) {
}
