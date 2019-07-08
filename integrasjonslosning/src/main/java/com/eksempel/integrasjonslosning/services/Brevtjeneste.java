package com.eksempel.integrasjonslosning.services;

import com.eksempel.integrasjonslosning.dtos.ForsikringsDto;

public interface Brevtjeneste {
    boolean sendEpost(ForsikringsDto forsikringsDto);
}
