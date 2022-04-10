package org.acme.controller;

import org.acme.models.History;
import org.acme.models.Vinjeta;
import org.acme.service.VinjetaService;

import java.util.*;
import java.text.SimpleDateFormat;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

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
