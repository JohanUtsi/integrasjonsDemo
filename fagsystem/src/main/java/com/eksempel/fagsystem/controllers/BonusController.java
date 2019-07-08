package com.eksempel.fagsystem.controllers;

import com.eksempel.fagsystem.dtos.BonusDto;
import com.eksempel.fagsystem.dtos.BonuserDto;
import com.eksempel.fagsystem.services.BonusService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "bonusResurser")
@Path("/bonus")
public class BonusController {

    //JAX-RS via Jersey støtter ikke constructors i controllers, derfor bruker jeg spring sin @Autowired
    @Autowired
    private BonusService bonusService;

    @GET
    @Produces("application/json")
    public Response getAllBonuses(){

        return Response.status(Response.Status.OK)
                .entity(this.bonusService.getAll())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .build();
    }

    //mest laget kun for å teste POST med noe enkelt
    @POST
    @Consumes("application/json")
    public Response createBonus(BonusDto bonusDto){
        return Response
                .status(Response.Status.CREATED)
                .entity(this.bonusService.create(bonusDto.getNavn()))
                .build();
    }
}
