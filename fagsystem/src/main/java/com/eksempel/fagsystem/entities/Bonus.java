package com.eksempel.fagsystem.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bonus")
public class Bonus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name ="navn")
    String navn;
}
