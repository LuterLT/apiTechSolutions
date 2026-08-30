package br.com.techsolutionsglobal.tarefastechsolutions.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private int prioridade;
    private boolean concluida = false;
    private boolean ativo = true;

    // Constructors --------------------------------
    public Tarefa() {
    }
    public Tarefa(String titulo, String descricao, int prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
    }

    // Getters ----------------------------------------
    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getDescricao() {
        return descricao;
    }
    public int getPrioridade() {
        return prioridade;
    }
    public boolean getConcluida() { return concluida;}
    public boolean getAtivo() { return ativo;}

    // Setters -----------------------------------------
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
    public void setConcluida(boolean concluida) { this.concluida = concluida; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}
