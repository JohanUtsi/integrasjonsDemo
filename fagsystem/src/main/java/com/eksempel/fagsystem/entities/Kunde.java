package com.eksempel.fagsystem.entities;

import com.eksempel.fagsystem.entities.enums.BooleanType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Kunde", schema = "forsikringer")
public class Kunde implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "fornavn", nullable = false)
    String fornavn;

    @Column(name = "etternavn", nullable = false)
    String etternavn;

    @Column(name = "fodselsnummer", nullable = false, unique = true)
    Long fodselsnummer;

    @Column(name = "epost", nullable = false, unique = true)
    String epost;

    @Column(name = "aktiv", nullable = false)
    BooleanType aktiv;

    @Column(name = "opprettet")
    LocalDateTime opprettet;

    @Column(name = "endret")
    LocalDateTime endret;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "kunde")
    private List<Registreringsnummer> registreringsnummer;
}
