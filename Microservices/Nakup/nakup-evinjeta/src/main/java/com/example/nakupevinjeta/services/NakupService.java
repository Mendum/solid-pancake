package com.example.nakupevinjeta.services;

import com.example.nakupevinjeta.databseClient.MongoService;
import com.example.nakupevinjeta.models.Nakup;
import com.example.nakupevinjeta.repository.NakupRepositoty;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class NakupService {

    private final NakupRepositoty nakupRepositoty;
    private final MongoService mongoService;

    public List<Nakup> getNakupList() {
        return  null;
        //return nakupRepositoty.findOne()
    }

    public List<Nakup> getAllNakupList(){
        return nakupRepositoty.findAll();
    }

    public Integer getLastBillInternalCode(){
        return mongoService.findLastBillInternalCode();
    }

    public Nakup newNakup(String content){
        try {
            Integer lastBillInternalCode = getLastBillInternalCode();
            Integer newBillInternalCode = lastBillInternalCode + 1;
            return nakupRepositoty.insert(
                    new Nakup(
                            newBillInternalCode,
                            content,
                            LocalDateTime.now()
                    )
            );
        }catch (Exception e) {
            return null;
        }
    }

    public boolean removeNakup() {
        return true;
    }

}
