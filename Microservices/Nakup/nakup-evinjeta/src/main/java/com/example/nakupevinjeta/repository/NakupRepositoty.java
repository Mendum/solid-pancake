package com.example.nakupevinjeta.repository;

import java.util.List;

import com.example.nakupevinjeta.models.Nakup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NakupRepositoty
        extends MongoRepository<Nakup, String> {
}