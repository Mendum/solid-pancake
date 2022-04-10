package org.acme.controller;

import org.acme.consumer.VinjetaConsumer;
import org.acme.models.History;
import org.acme.models.Vinjeta;
import org.acme.service.VinjetaService;

import java.util.*;
import java.text.SimpleDateFormat;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/vinjeta")
public class VinjetaResource {

    private Set<Vinjeta> vinjete = Collections
            .newSetFromMap(
                    Collections.synchronizedMap(new LinkedHashMap<>())
            );

    public VinjetaResource() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        vinjete.add(
                new Vinjeta(
                        "AF8C3FH24H3",
                        formatter.format(date),
                        formatter.format(date),
                        "letni",
                        "SI",
                        "MB-J1-431",
                        "PayPal",
                        true
                )
        );
    }

    @Inject
    VinjetaConsumer consumer;

    @GET
    @Path("/last")
    @Produces(MediaType.TEXT_PLAIN)
    public String last() {
        return consumer.getIdentifikator();
    }

    @GET
    public Set<Vinjeta> list() {
        return vinjete;
    }

    @POST
    public Set<Vinjeta> add(Vinjeta vinjeta) {
        vinjete.add(vinjeta);
        return vinjete;
    }

    // hranjenje zgodovine poročil o preverjanju posamezne vinjete
    @GET
    @Path("/history")
    public List<History> lisHistory() {
        return VinjetaService.listZgodovina();
    }

}
