package com.eksempel.fagsystem.services.impl;

import com.eksempel.fagsystem.daos.BonusRepository;
import com.eksempel.fagsystem.dtos.BonusDto;
import com.eksempel.fagsystem.dtos.BonuserDto;
import com.eksempel.fagsystem.entities.Bonus;
import com.eksempel.fagsystem.services.BonusService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BonusServiceImpl implements BonusService {

    BonusRepository bonusRepository;

    public BonusServiceImpl(BonusRepository bonusRepository) {
        this.bonusRepository = bonusRepository;
    }

    @Override
    public BonuserDto getAll(){
        return toDto(this.bonusRepository.findAll());
    }

    @Override
    public void create(String navn) {
        Bonus bonus = new Bonus();
        bonus.setNavn(navn);
        bonusRepository.save(bonus);
    }

    private BonuserDto toDto(List<Bonus> bonuser) {
        BonuserDto bonuserDto = new BonuserDto();
        List<BonusDto> bonusList = new ArrayList<>();
        for (Bonus bonus : bonuser
             ) {
            BonusDto bonusDto = new BonusDto();
            bonusDto.setId(bonus.getId());
            bonusDto.setNavn(bonus.getNavn());
            bonusList.add(bonusDto);
        }
        bonuserDto.setBonuser(bonusList);
        return bonuserDto;
    }

}
