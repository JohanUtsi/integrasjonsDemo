package com.eksempel.integrasjonslosning.services.impl;

import com.eksempel.integrasjonslosning.dtos.*;
import com.eksempel.integrasjonslosning.services.ForsikringsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class ForsikringsServiceImpl implements ForsikringsService {

    private final RestTemplate restTemplate;

    @Value("${backend.url}")
    private String url;

    public ForsikringsServiceImpl(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    @Override
    public AvtaleStatusDto opprettAvtale(ForsikringsDto forsikringsDto){
        HttpEntity<KundeDto> kundeRequest = new HttpEntity<>(setupKundeDto(forsikringsDto));
        Long kundeId = this.restTemplate.postForObject(this.url+"/kunde", kundeRequest, Long.class);

        AvtaleStatusDto avtaleStatusDto = new AvtaleStatusDto();

        if(kundeId != null){
            HttpEntity<RegNummerDto> regnummerRequest = new HttpEntity<>(setupRegnummerDto(kundeId, forsikringsDto.getRegnummer()));
            Long regnummerId = this.restTemplate.postForObject(this.url+"/regnummer", regnummerRequest, Long.class);

            if(regnummerId!=null){
                AvtaleDto avtaleDto = setupAvtaleDto(kundeId, regnummerId, forsikringsDto.getBonusId());
                HttpEntity<AvtaleDto> avtaleRequest = new HttpEntity<>(avtaleDto);
                AvtaleStatusDto returStatusDto = this.restTemplate.postForObject(this.url+"/avtale", avtaleRequest, AvtaleStatusDto.class);
                avtaleStatusDto = returStatusDto;
            }
        }

        return avtaleStatusDto;
    }

    private AvtaleDto setupAvtaleDto(Long kundeId, Long regnummerId, Long bonusId) {
        AvtaleDto avtaleDto = new AvtaleDto();
        avtaleDto.setBrukerId(kundeId);
        avtaleDto.setRegnummerId(regnummerId);
        avtaleDto.setBonusType(bonusId);
        avtaleDto.setStatus(sjekkStatus(kundeId));
        return avtaleDto;
    }

    private Long sjekkStatus(Long kundeId) {
        //Her skulle det ha vært logikk for å sjekke om kunden får godkjent eller ikke godkjent på forsikringsavtalen.
        return (long)(new Random().nextInt(2) + 1);
    }

    private RegNummerDto setupRegnummerDto(Long kundeId, String regnummer) {
        RegNummerDto regNummerDto = new RegNummerDto();
        regNummerDto.setKundeId(kundeId);
        regNummerDto.setRegNummer(regnummer);
        return regNummerDto;
    }

    private KundeDto setupKundeDto(ForsikringsDto forsikringsDto) {
        KundeDto kundeDto = new KundeDto();
        kundeDto.setFornavn(forsikringsDto.getFornavn());
        kundeDto.setEtternavn(forsikringsDto.getEtternavn());
        kundeDto.setEpost(forsikringsDto.getEpost());
        kundeDto.setFodselsnummer(forsikringsDto.getFodselsnummer());

        return kundeDto;
    }
}
