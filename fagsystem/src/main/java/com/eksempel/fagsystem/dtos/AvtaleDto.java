package com.eksempel.fagsystem.dtos;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "avtale")
public class AvtaleDto {

    @XmlAttribute(name="id")
    private Long id;

    @XmlAttribute(name="brukerid")
    private Long brukerId;

    @XmlAttribute(name="regnummerid")
    private Long regnummerId;

    @XmlAttribute(name="bonustype")
    private Long bonusType;

    @XmlAttribute(name="status")
    private Long status;
}
