package org.acme.models;

import java.util.Date;

public class Vinjeta {

    private String id;
    private String identifikator;
    private String zacetekVeljavnosti;
    private String konecVeljavnosti;
    private String cestninskiRazred; //tedenska, mesecna, letna
    private String drzavaRegistracije;
    public String registrskaOznacba;
    private String nacinPlacila;
    private Boolean prebralSemSplosnePogojeUporabeSpletneTrgovineInPolitikiZasebnostiTerSeZNjimaStrinjam;

    public Vinjeta() {}

    public Vinjeta(
            String identifikator,
            String zacetekVeljavnosti,
            String konecVeljavnosti,
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentifikator() {
        return identifikator;
    }

    public void setIdentifikator(String identifikator) {
        this.identifikator = identifikator;
    }

    public String getZacetekVeljavnosti() {
        return zacetekVeljavnosti;
    }

    public void setZacetekVeljavnosti(String zacetekVeljavnosti) {
        this.zacetekVeljavnosti = zacetekVeljavnosti;
    }

    public String getKonecVeljavnosti() {
        return konecVeljavnosti;
    }

    public void setKonecVeljavnosti(String konecVeljavnosti) {
        this.konecVeljavnosti = konecVeljavnosti;
    }

    public String getCestninskiRazred() {
        return cestninskiRazred;
    }

    public void setCestninskiRazred(String cestninskiRazred) {
        this.cestninskiRazred = cestninskiRazred;
    }

    public String getDrzavaRegistracije() {
        return drzavaRegistracije;
    }

    public void setDrzavaRegistracije(String drzavaRegistracije) {
        this.drzavaRegistracije = drzavaRegistracije;
    }

    public String getRegistrskaOznacba() {
        return registrskaOznacba;
    }

    public void setRegistrskaOznacba(String registrskaOznacba) {
        this.registrskaOznacba = registrskaOznacba;
    }

    public String getNacinPlacila() {
        return nacinPlacila;
    }

    public void setNacinPlacila(String nacinPlacila) {
        this.nacinPlacila = nacinPlacila;
    }

    public Boolean getPrebralSemSplosnePogojeUporabeSpletneTrgovineInPolitikiZasebnostiTerSeZNjimaStrinjam() {
        return prebralSemSplosnePogojeUporabeSpletneTrgovineInPolitikiZasebnostiTerSeZNjimaStrinjam;
    }

    public void setPrebralSemSplosnePogojeUporabeSpletneTrgovineInPolitikiZasebnostiTerSeZNjimaStrinjam(Boolean prebralSemSplosnePogojeUporabeSpletneTrgovineInPolitikiZasebnostiTerSeZNjimaStrinjam) {
        this.prebralSemSplosnePogojeUporabeSpletneTrgovineInPolitikiZasebnostiTerSeZNjimaStrinjam = prebralSemSplosnePogojeUporabeSpletneTrgovineInPolitikiZasebnostiTerSeZNjimaStrinjam;
    }

    @Override
    public String toString() {
        return "Vinjeta{" +
                "identifikator='" + identifikator + '\'' +
                ", zacetekVeljavnosti='" + zacetekVeljavnosti + '\'' +
                ", konecVeljavnosti='" + konecVeljavnosti + '\'' +
                ", cestninskiRazred='" + cestninskiRazred + '\'' +
                ", drzavaRegistracije='" + drzavaRegistracije + '\'' +
                ", registrskaOznacba='" + registrskaOznacba + '\'' +
                ", nacinPlacila='" + nacinPlacila + '\'' +
                ", prebralSemSplosnePogojeUporabeSpletneTrgovineInPolitikiZasebnostiTerSeZNjimaStrinjam=" + prebralSemSplosnePogojeUporabeSpletneTrgovineInPolitikiZasebnostiTerSeZNjimaStrinjam +
                '}';
    }
}
