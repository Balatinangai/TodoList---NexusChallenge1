package com.example.todolist.repository; // Pacote onde o repositório está localizado

import com.example.todolist.model.Task; // Importa o modelo Task
import org.springframework.data.jpa.repository.JpaRepository; // Importa JpaRepository para operações CRUD

public interface TaskRepository extends JpaRepository<Task, Long> {
}
