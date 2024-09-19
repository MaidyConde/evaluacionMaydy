package com.evaluacion.evaluacion.Models;


import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Tarea") 
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "title", nullable = false, length = 36)
    private String title;

    @Column(name = "dueDate", nullable = false, length = 36)
    private Date dueDate;

    @Column(name = "assignedTo", nullable = false, length = 36)
    private String assignedTo;

    @Column(name = "status", nullable = false, length = 36)
    private String status;

    @Enumerated(EnumType.STRING)
    private Status Status;

}