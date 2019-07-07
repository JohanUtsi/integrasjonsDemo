package com.eksempel.integrasjonslosning.services;

import com.eksempel.integrasjonslosning.dtos.AvtaleStatusDto;
import com.eksempel.integrasjonslosning.dtos.ForsikringsDto;

public interface ForsikringsService {
    AvtaleStatusDto opprettAvtale(ForsikringsDto forsikringsDto);
}
