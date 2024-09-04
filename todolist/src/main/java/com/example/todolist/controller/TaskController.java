package com.example.todolist.controller; // Pacote onde o controlador está localizado

import com.example.todolist.model.Task; // Importa a classe Task, que representa a entidade tarefa
import com.example.todolist.service.TaskService; // Importa o serviço TaskService, que contém a lógica de negócios para gerenciar tarefas
import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação para injeção de dependência
import org.springframework.web.bind.annotation.*; // Importa as anotações para criar endpoints REST

import java.util.List; // Importa a classe List para manipulação de listas

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/api/tasks") // Define o caminho base para todos os endpoints neste controlador
public class TaskController {

    @Autowired // Injeta automaticamente a dependência do TaskService
    private TaskService taskService;

    // Endpoint para recuperar todas as tarefas
    @GetMapping
    public List<Task> getAllTasks() {
        // Chama o serviço de tarefas para obter todas as tarefas e retorna a lista
        return taskService.getAllTasks();
    }

    // Endpoint para recuperar uma tarefa específica pelo ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        // Chama o serviço de tarefas para obter a tarefa com o ID especificado e retorna a tarefa
        return taskService.getTaskById(id);
    }

    // Endpoint para criar uma nova tarefa
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        // Chama o serviço de tarefas para criar uma nova tarefa com base nos dados fornecidos e retorna a tarefa criada
        return taskService.createTask(task);
    }

    // Endpoint para atualizar uma tarefa existente
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        // Chama o serviço de tarefas para atualizar a tarefa com o ID especificado com base nos dados fornecidos e retorna a tarefa atualizada
        return taskService.updateTask(id, task);
    }

    // Endpoint para excluir uma tarefa existente
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        // Chama o serviço de tarefas para excluir a tarefa com o ID especificado
        taskService.deleteTask(id);
    }
}
