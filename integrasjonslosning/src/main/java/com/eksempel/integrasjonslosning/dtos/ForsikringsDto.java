package com.eksempel.integrasjonslosning.dtos;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "forsikring")
public class ForsikringsDto {

    @XmlAttribute(name="regNummer")
    private String regnummer;

    @XmlAttribute(name="bonusid")
    private Long bonusId;

    @XmlAttribute(name="fodselsnummer")
    private Long fodselsnummer;

    @XmlAttribute(name="fornavn")
    private String fornavn;

    @XmlAttribute(name="etternavn")
    private String etternavn;

    @XmlAttribute(name = "epost")
    private String epost;
}
