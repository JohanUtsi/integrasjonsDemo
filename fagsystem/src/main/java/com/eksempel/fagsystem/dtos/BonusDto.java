package com.eksempel.fagsystem.dtos;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "bonus")
public class BonusDto implements Serializable {

    @XmlAttribute(name="id")
    private Long id;

    @XmlAttribute(name = "navn")
    private String navn;
}
