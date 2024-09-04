package com.example.todolist.dto; // Pacote onde a classe DTO está localizada

import java.time.LocalDate; // Importação da classe LocalDate para manipulação de datas

public class TaskDTO {

    private Long id; // Identificador único da tarefa
    private String title; // Título da tarefa
    private String description; // Descrição da tarefa
    private LocalDate dueDate; // Data de vencimento da tarefa
    private String priority; // Prioridade da tarefa (ex: Alta, Média, Baixa)
    private String status; // Status da tarefa (ex: Pendente, Em Progresso, Concluída)

    // Getters and Setters
    public Long getId() {
        return id; // Retorna o identificador da tarefa
    }

    public void setId(Long id) {
        this.id = id; // Define o identificador da tarefa
    }

    public String getTitle() {
        return title; // Retorna o título da tarefa
    }

    public void setTitle(String title) {
        this.title = title; // Define o título da tarefa
    }

    public String getDescription() {
        return description; // Retorna a descrição da tarefa
    }

    public void setDescription(String description) {
        this.description = description; // Define a descrição da tarefa
    }

    public LocalDate getDueDate() {
        return dueDate; // Retorna a data de vencimento da tarefa
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate; // Define a data de vencimento da tarefa
    }

    public String getPriority() {
        return priority; // Retorna a prioridade da tarefa
    }

    public void setPriority(String priority) {
        this.priority = priority; // Define a prioridade da tarefa
    }

    public String getStatus() {
        return status; // Retorna o status da tarefa
    }

    public void setStatus(String status) {
        this.status = status; // Define o status da tarefa
    }
}
