package com.eksempel.fagsystem.dtos;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "bonuser")
public class BonuserDto {

    @XmlElement(name = "bonus")
    private List<BonusDto> bonuser;

}
