package br.com.diegoviana.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity(name="tb-tasks")
public class TaskModel {
    /**
     * Uma Tarefa terá:
     * 
     * ID(id do usuário)
     * Usuário
     * Descrição
     * Título
     * Data de Inicio
     * Data de Termino
     * Prioridade da tarefa
     * 
     */
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;

    @Column(length = 50)
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;
    private UUID idUser;
    
    @CreationTimestamp
    private LocalDateTime createdAt;
}
