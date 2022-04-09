package com.example.nakupevinjeta.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Vinjeta {

    @Id
    private String id;
    @Indexed(unique = true)
    private String stevilka;
    private LocalDateTime date;

    public Vinjeta(String stevilka, LocalDateTime date) {
        this.stevilka = stevilka;
        this.date = date;
    }
}