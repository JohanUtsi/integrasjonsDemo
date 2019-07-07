package com.eksempel.fagsystem.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "registreringsnummer")
public class Registreringsnummer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER) // eager because it should always load.
    @JoinColumn(name = "brukerId", nullable = false)
    private Kunde kunde;

    @Column(name = "registreringsnummer")
    private String regNummer;
}
