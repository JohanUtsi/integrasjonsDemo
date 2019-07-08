package com.eksempel.fagsystem.services;

import com.eksempel.fagsystem.dtos.AvtaleDto;
import com.eksempel.fagsystem.dtos.AvtaleStatusDto;

public interface AvtaleService {
    AvtaleStatusDto create(AvtaleDto avtaleDto);

    AvtaleStatusDto update(AvtaleDto avtaleDto);
}
