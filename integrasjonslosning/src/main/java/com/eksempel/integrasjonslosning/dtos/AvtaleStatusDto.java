package com.eksempel.integrasjonslosning.dtos;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "avtalestatus")
public class AvtaleStatusDto {
    @XmlAttribute(name="avtalenummer")
    private Long avtalenummer;

    @XmlAttribute(name="status")
    private String status;
}
