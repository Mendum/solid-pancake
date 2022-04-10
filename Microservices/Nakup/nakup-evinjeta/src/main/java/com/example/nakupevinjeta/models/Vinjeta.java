package com.example.nakupevinjeta.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Vinjeta {

    @Indexed(unique = true)
    private String identifikator;
    private LocalDateTime zacetekVeljavnosti;
    private LocalDateTime konecVeljavnosti;
    private String cestninskiRazred; //tedenska, mesecna, letna
    private String drzavaRegistracije;
    public String registrskaOznacba;
    private String nacinPlacila;
    private Boolean prebralSemSplosnePogojeUporabeSpletneTrgovineInPolitikiZasebnostiTerSeZNjimaStrinjam;

    public Vinjeta() {}

    public Vinjeta(
            String identifikator,
            LocalDateTime zacetekVeljavnosti,
            LocalDateTime konecVeljavnosti,
            String cestninskiRazred,
            String drzavaRegistracije,
            String registrskaOznacba,
            String nacinPlacila,
            Boolean prebralSemSplosnePogojeUporabeSpletneTrgovineInPolitikiZasebnostiTerSeZNjimaStrinjam
    ) {
        this.identifikator = identifikator;
        this.zacetekVeljavnosti = zacetekVeljavnosti;
        this.konecVeljavnosti = konecVeljavnosti;
        this.cestninskiRazred = cestninskiRazred;
        this.drzavaRegistracije = drzavaRegistracije;
        this.registrskaOznacba = registrskaOznacba;
        this.nacinPlacila = nacinPlacila;
        this.prebralSemSplosnePogojeUporabeSpletneTrgovineInPolitikiZasebnostiTerSeZNjimaStrinjam = prebralSemSplosnePogojeUporabeSpletneTrgovineInPolitikiZasebnostiTerSeZNjimaStrinjam;
    }
}