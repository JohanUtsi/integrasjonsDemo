package com.eksempel.integrasjonslosning.services.impl;

import com.eksempel.integrasjonslosning.dtos.ForsikringsDto;
import com.eksempel.integrasjonslosning.services.Brevtjeneste;
import org.springframework.stereotype.Service;

@Service
public class BrevtjenesteImpl implements Brevtjeneste {
    @Override
    public boolean sendEpost(ForsikringsDto forsikringsDto) {
        try{
            //Her kan vi late som at den sender brev via epost adressen i Dto
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
