package com.eksempel.fagsystem.dtos;

import com.eksempel.fagsystem.entities.enums.BooleanType;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "kunde")
public class KundeDto {

    @XmlAttribute(name="id")
    private Long id;

    @XmlAttribute(name="fornavn")
    private String fornavn;

    @XmlAttribute(name="etternavn")
    private String etternavn;

    @XmlAttribute(name="fodselsnummer")
    private Long fodselsnummer;

    @XmlAttribute(name="epost")
    private String epost;

    @XmlAttribute(name="aktiv")
    private BooleanType aktiv;

}
