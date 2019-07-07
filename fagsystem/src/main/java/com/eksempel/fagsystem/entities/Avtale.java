package com.eksempel.fagsystem.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "avtale", schema = "forsikringer")
public class Avtale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER) // eager because it should always load.
    @JoinColumn(name = "bruker_id", nullable = false)
    private Kunde kunde;

    @ManyToOne(fetch = FetchType.EAGER) // eager because it should always load.
    @JoinColumn(name = "regnummer_id", nullable = false)
    private Registreringsnummer registreringsnummer;

    @ManyToOne(fetch = FetchType.EAGER) // eager because it should always load.
    @JoinColumn(name = "bonus_type", nullable = false)
    private Bonus bonus;

    @ManyToOne(fetch = FetchType.EAGER) // eager because it should always load.
    @JoinColumn(name = "status", nullable = false)
    private Status status;
}
