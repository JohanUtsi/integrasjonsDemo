package com.eksempel.fagsystem.dtos;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
public class AvtaleStatusDto implements Serializable {
    private Long avtalenummer;
    private String status;
}
