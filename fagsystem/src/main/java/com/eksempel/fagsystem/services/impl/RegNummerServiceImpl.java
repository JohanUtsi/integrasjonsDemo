package com.eksempel.fagsystem.services.impl;

import com.eksempel.fagsystem.daos.KundeRepository;
import com.eksempel.fagsystem.daos.RegNummerRepository;
import com.eksempel.fagsystem.dtos.RegNummerDto;
import com.eksempel.fagsystem.entities.Registreringsnummer;
import com.eksempel.fagsystem.services.RegNummerService;
import org.springframework.stereotype.Service;

@Service
public class RegNummerServiceImpl implements RegNummerService {

    private RegNummerRepository regNummerRepository;
    private KundeRepository kundeRepository;

    public RegNummerServiceImpl(RegNummerRepository regNummerRepository,
                                KundeRepository kundeRepository) {
        this.regNummerRepository = regNummerRepository;
        this.kundeRepository = kundeRepository;
    }

    @Override
    public Long create(RegNummerDto regNummerDto){
        Registreringsnummer registreringsnummer = toEntity(regNummerDto);
        this.regNummerRepository.save(registreringsnummer);
        return registreringsnummer.getId();
    }

    private Registreringsnummer toEntity(RegNummerDto regNummerDto) {
        Registreringsnummer registreringsnummer = new Registreringsnummer();
        registreringsnummer.setKunde(kundeRepository.findById(regNummerDto.getKundeId()).orElse(null));
        registreringsnummer.setRegNummer(regNummerDto.getRegNummer());
        return registreringsnummer;
    }
}
