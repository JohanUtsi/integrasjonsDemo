package com.eksempel.fagsystem.dtos;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "registreringsnummerResurser")
public class RegNummerDto {

    @XmlAttribute(name="id")
    private Long id;

    @XmlAttribute(name="kundeId")
    private Long kundeId;

    @XmlAttribute(name="regNummer")
    private String regNummer;
}
