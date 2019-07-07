package com.eksempel.fagsystem.daos;

import com.eksempel.fagsystem.entities.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BonusRepository extends JpaRepository<Bonus, Long> {
}
