package com.eksempel.fagsystem.services.impl;

import com.eksempel.fagsystem.daos.KundeRepository;
import com.eksempel.fagsystem.dtos.KundeDto;
import com.eksempel.fagsystem.entities.Kunde;
import com.eksempel.fagsystem.entities.enums.BooleanType;
import com.eksempel.fagsystem.services.KundeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KundeServiceImpl implements KundeService {

    private KundeRepository kundeRepository;

    public KundeServiceImpl(KundeRepository kundeRepository) {
        this.kundeRepository = kundeRepository;
    }

    @Override
    public Long create(KundeDto kundeDto) {
        Kunde kunde = toEntity(kundeDto);
        this.kundeRepository.save(kunde);
        return kunde.getId();
    }

    private Kunde toEntity(KundeDto kundeDto) {
        Kunde kunde = new Kunde();
        kunde.setFornavn(kundeDto.getFornavn());
        kunde.setEtternavn(kundeDto.getEtternavn());
        kunde.setFodselsnummer(kundeDto.getFodselsnummer());
        kunde.setEpost(kundeDto.getEpost());
        kunde.setAktiv(BooleanType.TRUE);
        kunde.setOpprettet(LocalDateTime.now());

        return kunde;
    }
}
