package com.eksempel.fagsystem.daos;

import com.eksempel.fagsystem.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
