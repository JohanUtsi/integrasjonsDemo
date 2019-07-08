package com.eksempel.fagsystem.services.impl;

import com.eksempel.fagsystem.daos.*;
import com.eksempel.fagsystem.dtos.AvtaleDto;
import com.eksempel.fagsystem.dtos.AvtaleStatusDto;
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
    public AvtaleStatusDto create(AvtaleDto avtaleDto){
        return getAvtaleStatus(avtaleDto);
    }

    @Override
    public AvtaleStatusDto update(AvtaleDto avtaleDto) {
        return getAvtaleStatus(avtaleDto);
    }

    //for å unngå duplisert kode
    private AvtaleStatusDto getAvtaleStatus(AvtaleDto avtaleDto){
        Avtale avtale = toEntity(avtaleDto);
        this.avtaleRepository.save(avtale);
        AvtaleStatusDto avtaleStatusDto = new AvtaleStatusDto();
        avtaleStatusDto.setAvtalenummer(avtale.getId());
        avtaleStatusDto.setStatus(statusRepository.findById(avtale.getStatus().getId())
                .orElse(null).getStatus());
        return avtaleStatusDto;
    }

    private Avtale toEntity(AvtaleDto avtaleDto) {
        Avtale avtale = new Avtale();
        if(avtaleDto.getId()!=null){
            avtale.setId(avtaleDto.getId());
        }
        avtale.setKunde(this.kundeRepository.findById(avtaleDto.getBrukerId()).orElse(null));
        avtale.setRegistreringsnummer(this.regNummerRepository.findById(avtaleDto.getRegnummerId()).orElse(null));
        avtale.setBonus(this.bonusRepository.findById(avtaleDto.getBonusType()).orElse(null));
        avtale.setStatus(this.statusRepository.findById(avtaleDto.getStatus()).orElse(null));

        return avtale;
    }
}
