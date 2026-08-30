package br.com.techsolutionsglobal.tarefastechsolutions.repository;

import br.com.techsolutionsglobal.tarefastechsolutions.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
