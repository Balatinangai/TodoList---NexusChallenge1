package com.example.todolist.service; // Pacote onde o serviço de tarefas está localizado

import com.example.todolist.model.Task; // Importa a classe Task que representa a entidade de tarefa
import com.example.todolist.repository.TaskRepository; // Importa o repositório de tarefas para acessar dados do banco
import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação para injeção de dependências
import org.springframework.stereotype.Service; // Importa a anotação para marcar a classe como um serviço

import java.util.List; // Importa a classe List para manipular listas de tarefas

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository; // Repositório de tarefas para interagir com o banco de dados

    // Método para obter todas as tarefas
    public List<Task> getAllTasks() {
        return taskRepository.findAll(); // Busca todas as tarefas do banco de dados
    }

    // Método para obter uma tarefa por ID
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Task not found")); // Lança exceção se a tarefa não for encontrada
    }

    // Método para criar uma nova tarefa
    public Task createTask(Task task) {
        return taskRepository.save(task); // Salva a tarefa no banco de dados
    }

    // Método para atualizar uma tarefa existente
    public Task updateTask(Long id, Task task) {
        task.setId(id); // Define o ID da tarefa a ser atualizado
        return taskRepository.save(task); // Atualiza a tarefa no banco de dados
    }

    // Método para deletar uma tarefa por ID
    public void deleteTask(Long id) {
        taskRepository.deleteById(id); // Remove a tarefa do banco de dados
    }
}
