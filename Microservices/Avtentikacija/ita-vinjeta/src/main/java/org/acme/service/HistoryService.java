package org.acme.service;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import com.mongodb.client.MongoCursor;
import org.acme.controller.HistoryResource;
import org.acme.models.History;
import org.acme.models.Vinjeta;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class HistoryService {

    @Inject MongoClient mongoClient;



    public List<History> list(){
        List<History> list = new ArrayList<>();
        MongoCursor<Document> cursor = getCollection().find().iterator();

        try {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                History history = new History();
                history.setResult(document.getString("result"));
                history.setDateOfCheck(document.getString("dateOfCheck"));
                history.setVinjetaIdentifikatorCheck(document.getString("vinjetaIdentifikatorCheck"));
                history.setValidity(document.getBoolean("validity") == null ? false : document.getBoolean("validity"));
                list.add(history);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public void add(History history){
        Document document = new Document()
                .append("result", history.getResult())
                .append("identifikator", history.getDateOfCheck())
                .append("vinjetaIdentifikatorCheck", history.getVinjetaIdentifikatorCheck())
                .append("validity", history.isValidity());
        getCollection().insertOne(document);
    }

    public List<History> findByVinjetaIdentifikatorCheck(String VinjetaIdentifikatorCheck){
        List<History> temp_list = new ArrayList<>();
        for (History h: list()) {
            if(h.getVinjetaIdentifikatorCheck() != null){
                if (h.getVinjetaIdentifikatorCheck().equals(VinjetaIdentifikatorCheck)){
                    temp_list.add(h);
                }
            }
        }

        return temp_list;
    }

    private MongoCollection getCollection(){
        return mongoClient.getDatabase("vinjeta").getCollection("history");
    }

    /*public static void nekajnekaj(String vinjetaIdentifikator){

        Gson gson = new Gson();
        boolean validity = Boolean.getBoolean(gson.toJson(vinjetaIdentifikator));

        History newHistory = new History(
                "temp",
                LocalDateTime.now().toString(),
                vinjetaIdentifikator,
                validity
        );

    }*/

}