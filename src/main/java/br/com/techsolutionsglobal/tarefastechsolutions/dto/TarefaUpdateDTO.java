package br.com.techsolutionsglobal.tarefastechsolutions.dto;

public record TarefaUpdateDTO(
        String titulo,
        String descricao,
        int prioridade,
        boolean concluida,
        boolean ativo
) {
}
