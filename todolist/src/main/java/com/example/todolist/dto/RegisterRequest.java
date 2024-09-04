package com.example.todolist.dto; // Pacote onde a classe DTO está localizada

public class RegisterRequest {

    private String username; // Nome de usuário fornecido pelo usuário para registro
    private String password; // Senha fornecida pelo usuário para registro

    // Getters and Setters
    public String getUsername() {
        return username; // Retorna o nome de usuário
    }

    public void setUsername(String username) {
        this.username = username; // Define o nome de usuário
    }

    public String getPassword() {
        return password; // Retorna a senha
    }

    public void setPassword(String password) {
        this.password = password; // Define a senha
    }
}
