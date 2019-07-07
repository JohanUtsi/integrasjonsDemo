package com.eksempel.fagsystem.daos;

import com.eksempel.fagsystem.entities.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KundeRepository extends JpaRepository<Kunde, Long> {
}
