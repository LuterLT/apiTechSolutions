package br.com.techsolutionsglobal.tarefastechsolutions.dto;

public record TarefaCreateDTO(
        String titulo,
        String descricao,
        int prioridade
) {
}
