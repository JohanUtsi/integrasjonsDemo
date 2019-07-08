package com.eksempel.integrasjonslosning.services.impl;

import com.eksempel.integrasjonslosning.dtos.*;
import com.eksempel.integrasjonslosning.services.Brevtjeneste;
import com.eksempel.integrasjonslosning.services.ForsikringsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class ForsikringsServiceImpl implements ForsikringsService {

    private final RestTemplate restTemplate;
    private Brevtjeneste brevtjeneste;

    @Value("${backend.url}")
    private String url;

    public ForsikringsServiceImpl(RestTemplateBuilder restTemplate, Brevtjeneste brevtjeneste) {
        this.restTemplate = restTemplate.build();
        this.brevtjeneste = brevtjeneste;
    }

    @Override
    public AvtaleStatusDto opprettAvtale(ForsikringsDto forsikringsDto){
        AvtaleStatusDto avtaleStatusDto = new AvtaleStatusDto();
        Long kundeId = opprettKunde(forsikringsDto);

        if(kundeId != null){
            Long regnummerId = opprettRegNummer(kundeId, forsikringsDto);
            if(regnummerId!=null){
                AvtaleDto avtaleDto = setupAvtaleDto(kundeId, regnummerId, forsikringsDto.getBonusId());
                AvtaleStatusDto opprettetAvtaleStatus = opprettAvtale(avtaleDto);

                if(this.brevtjeneste.sendEpost(forsikringsDto)){ //Sjekke med brevtjenesten
                    avtaleDto.setStatus(2L); //status #2 er "Sendt"
                    avtaleStatusDto = oppdaterAvtale(avtaleDto);
                }else{
                    avtaleDto.setStatus(3L); // Status #3 er "Ikke Sendt"
                    avtaleStatusDto = oppdaterAvtale(avtaleDto);
                }
            }
        }

        return avtaleStatusDto;
    }

    private Long opprettKunde(ForsikringsDto forsikringsDto){
        HttpEntity<KundeDto> kundeRequest = new HttpEntity<>(setupKundeDto(forsikringsDto));
        return this.restTemplate.postForObject(this.url+"/kunde", kundeRequest, Long.class);
    }

    private Long opprettRegNummer(Long kundeId, ForsikringsDto forsikringsDto){
        HttpEntity<RegNummerDto> regnummerRequest = new HttpEntity<>(setupRegnummerDto(kundeId, forsikringsDto.getRegnummer()));
        return this.restTemplate.postForObject(this.url+"/regnummer", regnummerRequest, Long.class);
    }

    private AvtaleStatusDto opprettAvtale(AvtaleDto avtaleDto){
        HttpEntity<AvtaleDto> avtaleRequest = new HttpEntity<>(avtaleDto);
        return this.restTemplate.postForObject(this.url+"/avtale", avtaleRequest, AvtaleStatusDto.class);
    }

    private AvtaleStatusDto oppdaterAvtale(AvtaleDto avtaleDto){
        HttpEntity<AvtaleDto> avtaleRequest = new HttpEntity<>(avtaleDto);
        HttpEntity<AvtaleStatusDto> httpEntity = this.restTemplate.exchange(this.url+"/avtale", HttpMethod.PUT, avtaleRequest, AvtaleStatusDto.class);
        return httpEntity.getBody();
    }

    private AvtaleDto setupAvtaleDto(Long kundeId, Long regnummerId, Long bonusId) {
        AvtaleDto avtaleDto = new AvtaleDto();
        avtaleDto.setBrukerId(kundeId);
        avtaleDto.setRegnummerId(regnummerId);
        avtaleDto.setBonusType(bonusId);
        avtaleDto.setStatus(1L); //status #1 er "opprettet"
        return avtaleDto;
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
