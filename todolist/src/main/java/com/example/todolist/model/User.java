package com.example.todolist.model; // Pacote onde a entidade User está localizada

import javax.persistence.*; // Importa as classes necessárias do JPA

// Indica que esta classe é uma entidade JPA e será mapeada para uma tabela no banco de dados
@Entity
public class User {

    // Marca o campo 'id' como a chave primária da tabela
    @Id
    // Configura o campo 'id' para ser gerado automaticamente, usando a estratégia de incremento automático do banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único do usuário

    // Campo para armazenar o nome de usuário, que deve ser único e não pode ser nulo
    private String username;

    // Campo para armazenar a senha do usuário
    private String password;

    // Método getter para o campo 'id'
    public Long getId() {
        return id;
    }

    // Método setter para o campo 'id'
    public void setId(Long id) {
        this.id = id;
    }

    // Método getter para o campo 'username'
    public String getUsername() {
        return username;
    }

    // Método setter para o campo 'username'
    public void setUsername(String username) {
        this.username = username;
    }

    // Método getter para o campo 'password'
    public String getPassword() {
        return password;
    }

    // Método setter para o campo 'password'
    public void setPassword(String password) {
        this.password = password;
    }
}

