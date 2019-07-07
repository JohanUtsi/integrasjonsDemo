package com.eksempel.fagsystem.services.impl;

import com.eksempel.fagsystem.daos.*;
import com.eksempel.fagsystem.dtos.AvtaleDto;
import com.eksempel.fagsystem.entities.Avtale;
import com.eksempel.fagsystem.services.AvtaleService;
import org.springframework.stereotype.Service;

@Service
public class AvtaleServiceImpl implements AvtaleService {
    private AvtaleRepository avtaleRepository;
    private KundeRepository kundeRepository;
    private BonusRepository bonusRepository;
    private RegNummerRepository regNummerRepository;
    private StatusRepository statusRepository;

    public AvtaleServiceImpl(AvtaleRepository avtaleRepository, KundeRepository kundeRepository,
                             BonusRepository bonusRepository, RegNummerRepository regNummerRepository,
                             StatusRepository statusRepository) {
        this.avtaleRepository = avtaleRepository;
        this.bonusRepository = bonusRepository;
        this.kundeRepository = kundeRepository;
        this.regNummerRepository = regNummerRepository;
        this.statusRepository = statusRepository;
    }

    @Override
    public Long create(AvtaleDto avtaleDto){
        Avtale avtale = toEntity(avtaleDto);
        this.avtaleRepository.save(avtale);
        return avtale.getId();
    }

    private Avtale toEntity(AvtaleDto avtaleDto) {
        Avtale avtale = new Avtale();
        avtale.setKunde(this.kundeRepository.findById(avtaleDto.getBrukerId()).orElse(null));
        avtale.setRegistreringsnummer(this.regNummerRepository.findById(avtaleDto.getRegnummerId()).orElse(null));
        avtale.setBonus(this.bonusRepository.findById(avtaleDto.getBonusType()).orElse(null));
        avtale.setStatus(this.statusRepository.findById(avtaleDto.getStatus()).orElse(null));

        return avtale;
    }
}
