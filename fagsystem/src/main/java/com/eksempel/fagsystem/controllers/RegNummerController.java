package com.eksempel.fagsystem.controllers;

import com.eksempel.fagsystem.dtos.RegNummerDto;
import com.eksempel.fagsystem.services.RegNummerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "regnummerresurser")
@Path("/regnummer")
public class RegNummerController {

    @Autowired
    private RegNummerService regNummerService;

    @POST
    @Consumes("application/json")
    public Response create(RegNummerDto regNummerDto){
        try{
            this.regNummerService.create(regNummerDto);
            return Response.status(201).build();
        }catch(Exception e){
            return Response.status(409).build();
        }
    }
}
