package com.eksempel.fagsystem.controllers;

import com.eksempel.fagsystem.dtos.AvtaleDto;
import com.eksempel.fagsystem.services.AvtaleService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "avtaleResurser")
@Path("/avtale")
public class AvtaleController {

    @Autowired
    private AvtaleService avtaleService;

    @POST
    @Consumes("application/json")
    public Response create(AvtaleDto avtaleDto){
        try{
            this.avtaleService.create(avtaleDto);
            return Response.status(201).build();
        }catch(Exception e){
            return Response.status(409).build();
        }
    }
}
