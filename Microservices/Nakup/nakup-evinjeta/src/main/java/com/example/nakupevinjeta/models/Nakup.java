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
    private String content;
    private LocalDateTime date;

    public Nakup(){}

    public Nakup(
            Integer billInternalCode,
            String content,
            LocalDateTime date) {
        this.billInternalCode = billInternalCode;
        this.content = content;
        this.date = date;
    }

}
