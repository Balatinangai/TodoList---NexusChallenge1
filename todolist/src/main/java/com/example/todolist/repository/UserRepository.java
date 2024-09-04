package com.example.todolist.repository; // Pacote onde o repositório está localizado

import com.example.todolist.model.User; // Importa o modelo User
import org.springframework.data.jpa.repository.JpaRepository; // Importa JpaRepository para operações CRUD

public interface UserRepository extends JpaRepository<User, Long> {

    // Método personalizado para encontrar um usuário pelo nome de usuário
    User findByUsername(String username);
}
