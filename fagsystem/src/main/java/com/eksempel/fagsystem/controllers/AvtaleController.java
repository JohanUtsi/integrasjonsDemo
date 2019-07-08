package com.eksempel.fagsystem.controllers;

import com.eksempel.fagsystem.dtos.AvtaleDto;
import com.eksempel.fagsystem.services.AvtaleService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
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
    @Produces("application/json")
    public Response create(AvtaleDto avtaleDto) {
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(this.avtaleService.create(avtaleDto))
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(AvtaleDto avtaleDto){
        try {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(this.avtaleService.update(avtaleDto))
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
