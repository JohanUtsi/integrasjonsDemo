package com.eksempel.integrasjonslosning.controllers;

import com.eksempel.integrasjonslosning.dtos.AvtaleStatusDto;
import com.eksempel.integrasjonslosning.dtos.ForsikringsDto;
import com.eksempel.integrasjonslosning.services.ForsikringsService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "forsikringsresurser")
@Path("/forsikring")
public class ForsikringsController {

    @Autowired
    private ForsikringsService forsikringsService;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(ForsikringsDto forsikringsDto) {
        try {
            AvtaleStatusDto avtaleStatusDto = forsikringsService.opprettAvtale(forsikringsDto);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(avtaleStatusDto)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT)
                    .entity("Woops")
                    .build();
        }
    }
}
