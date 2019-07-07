package com.eksempel.fagsystem.daos;

import com.eksempel.fagsystem.entities.Registreringsnummer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegNummerRepository extends JpaRepository<Registreringsnummer, Long> {
}
