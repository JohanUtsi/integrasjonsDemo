package com.eksempel.fagsystem.services;

import com.eksempel.fagsystem.dtos.BonuserDto;

public interface BonusService {
    BonuserDto getAll();

    Long create(String navn);
}
