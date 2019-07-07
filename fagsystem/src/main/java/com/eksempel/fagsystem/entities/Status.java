package com.eksempel.fagsystem.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;
}
