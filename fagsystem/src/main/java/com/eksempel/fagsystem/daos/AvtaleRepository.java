package com.eksempel.fagsystem.daos;

import com.eksempel.fagsystem.entities.Avtale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvtaleRepository extends JpaRepository<Avtale, Long> {
}
