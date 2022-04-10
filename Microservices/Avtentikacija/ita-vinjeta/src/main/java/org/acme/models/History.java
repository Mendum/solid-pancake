package org.acme.models;

import java.util.Date;

public class History {

    private String result;
    private String dateOfCheck;
    private String vinjetaIdentifikatorCheck;
    private boolean validity;

    public History(){}

    public History(String result, String dateOfCheck, String vinjetaIdentifikatorCheck, boolean validity) {
        this.result = result;
        this.dateOfCheck = dateOfCheck;
        this.vinjetaIdentifikatorCheck = vinjetaIdentifikatorCheck;
        this.validity = validity;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDateOfCheck() {
        return dateOfCheck;
    }

    public void setDateOfCheck(String dateOfCheck) {
        this.dateOfCheck = dateOfCheck;
    }

    public String getVinjetaIdentifikatorCheck() {
        return vinjetaIdentifikatorCheck;
    }

    public void setVinjetaIdentifikatorCheck(String vinjetaIdentifikatorCheck) {
        this.vinjetaIdentifikatorCheck = vinjetaIdentifikatorCheck;
    }

    public boolean isValidity() {
        return validity;
    }

    public void setValidity(boolean validity) {
        this.validity = validity;
    }

    @Override
    public String toString() {
        return "History{" +
                "result='" + result + '\'' +
                ", dateOfCheck='" + dateOfCheck + '\'' +
                ", vinjetaIdentifikatorCheck='" + vinjetaIdentifikatorCheck + '\'' +
                ", validity=" + validity +
                '}';
    }
}
