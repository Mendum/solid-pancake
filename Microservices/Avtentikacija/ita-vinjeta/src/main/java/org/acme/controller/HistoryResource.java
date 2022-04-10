package org.acme.controller;

import org.acme.models.History;
import org.acme.service.HistoryService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.text.SimpleDateFormat;
import java.util.*;

@Path("/history")
public class HistoryResource {

    private Set<History> historys = Collections
            .newSetFromMap(
                    Collections.synchronizedMap(new LinkedHashMap<>())
            );

    public HistoryResource() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        historys.add(
                new History(
                    "okej",
                    "2022-04-10T18:49:40.376Z",
                    "b597e7fc3aeb260d",
                    true
                )
        );
    }

    @Inject HistoryService historyService;

    @GET
    @Path("/all")
    public List<History> list() {
        return historyService.list();
    }

    @GET
    @Path("/one")
    // @Path("/one/{identifikator}")
    // @PathParam String identifikator
    public List<History> listVinjetaIdentifikatorCheck(@QueryParam("identifikator") String identifikator) {
        return historyService.findByVinjetaIdentifikatorCheck(identifikator);
    }

    @POST
    @Path("/add")
    public List<History> add(History history) {
        historyService.add(history);
        return list();
    }
}
