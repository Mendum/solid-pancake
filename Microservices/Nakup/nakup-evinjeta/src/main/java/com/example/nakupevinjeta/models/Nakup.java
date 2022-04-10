package com.example.nakupevinjeta.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Nakup {

    @Id
    private ObjectId id;
    private Integer billInternalCode;
    private Vinjeta vinjeta;
    private LocalDateTime date;

    public Nakup(){}

    public Nakup(
            Integer billInternalCode,
            Vinjeta vinjeta,
            LocalDateTime date) {
        this.billInternalCode = billInternalCode;
        this.vinjeta = vinjeta;
        this.date = date;
    }

}
