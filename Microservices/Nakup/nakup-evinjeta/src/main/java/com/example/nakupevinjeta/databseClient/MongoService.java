package com.example.nakupevinjeta.databseClient;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Indexes.ascending;
import static com.mongodb.client.model.Indexes.descending;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import com.example.nakupevinjeta.models.Nakup;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoService {

    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private final MongoCollection<Nakup> collection;

    public MongoService() {

        CodecRegistry pojoCodecRegistry = fromRegistries(
                MongoClientSettings
                        .getDefaultCodecRegistry(),
                fromProviders(
                        PojoCodecProvider
                                .builder()
                                .automatic(true)
                                .build()
                )
        );

        MongoClientSettings settings = MongoClientSettings
                .builder()
                .applyConnectionString(new ConnectionString("mongodb://root:baza1@localhost:27018/?authSource=admin"))
                .codecRegistry(pojoCodecRegistry)
                .build();

        this.mongoClient = MongoClients.create(settings);
        this.database = mongoClient.getDatabase("vinjeta");
        this.collection = database.getCollection("nakup", Nakup.class);
    }

    public Integer findLastBillInternalCode() {

        try{

            Bson projectionFields = Projections.fields(
                    Projections.include("billInternalCode"),
                    Projections.excludeId());

            Nakup doc = collection.find()
                    .sort(Sorts.descending("billInternalCode"))
                    .first();

            return doc.getBillInternalCode();
        }catch(Exception e){
            System.out.println("No results found.");
            System.out.println(e.getMessage());
            return 1;
        }
    }

}
