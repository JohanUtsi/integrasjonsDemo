package com.eksempel.fagsystem.controllers;

import com.eksempel.fagsystem.dtos.BonusDto;
import com.eksempel.fagsystem.dtos.KundeDto;
import com.eksempel.fagsystem.services.KundeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "kundeResurser")
@Path("/kunde")
public class KundeController {

    @Autowired
    private KundeService kundeService;

    @POST
    @Consumes("application/json")
    public Response createKunde(KundeDto kundeDto){
        try{
            return Response
                    .status(Response.Status.CREATED)
                    .entity(this.kundeService.create(kundeDto))
                    .build();
        }catch(Exception e){
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
