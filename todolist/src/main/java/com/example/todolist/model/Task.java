package com.example.todolist.model; // Pacote onde a entidade Task está localizada

import javax.persistence.*; // Importa as classes necessárias do JPA
import java.time.LocalDate; // Importa a classe LocalDate para lidar com datas

// Indica que esta classe é uma entidade JPA e será mapeada para uma tabela no banco de dados
@Entity
public class Task {

    // Marca o campo 'id' como a chave primária da tabela
    @Id
    // Configura o campo 'id' para ser gerado automaticamente, usando a estratégia de incremento automático do banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único da tarefa

    // Campo para armazenar o título da tarefa
    private String title;

    // Campo para armazenar a descrição da tarefa
    private String description;

    // Campo para armazenar a data de vencimento da tarefa
    private LocalDate dueDate;

    // Campo para armazenar a prioridade da tarefa (por exemplo, Low, Medium, High)
    private String priority;

    // Campo para armazenar o status da tarefa (por exemplo, Pending, In Progress, Completed)
    private String status;

    // Método getter para o campo 'id'
    public Long getId() {
        return id;
    }

    // Método setter para o campo 'id'
    public void setId(Long id) {
        this.id = id;
    }

    // Método getter para o campo 'title'
    public String getTitle() {
        return title;
    }

    // Método setter para o campo 'title'
    public void setTitle(String title) {
        this.title = title;
    }

    // Método getter para o campo 'description'
    public String getDescription() {
        return description;
    }

    // Método setter para o campo 'description'
    public void setDescription(String description) {
        this.description = description;
    }

    // Método getter para o campo 'dueDate'
    public LocalDate getDueDate() {
        return dueDate;
    }

    // Método setter para o campo 'dueDate'
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    // Método getter para o campo 'priority'
    public String getPriority() {
        return priority;
    }

    // Método setter para o campo 'priority'
    public void setPriority(String priority) {
        this.priority = priority;
    }

    // Método getter para o campo 'status'
    public String getStatus() {
        return status;
    }

    // Método setter para o campo 'status'
    public void setStatus(String status) {
        this.status = status;
    }
}
