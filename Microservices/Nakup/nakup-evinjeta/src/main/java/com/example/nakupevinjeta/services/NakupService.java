package com.example.nakupevinjeta.services;

import com.example.nakupevinjeta.databseClient.MongoService;
import com.example.nakupevinjeta.models.Nakup;
import com.example.nakupevinjeta.models.Vinjeta;
import com.example.nakupevinjeta.repository.NakupRepositoty;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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

    public Nakup newNakup(){ //Vinjeta vinjeta
        try {

            //System.out.println("se tudi naredi");

            Vinjeta v = new Vinjeta(
                    "c4iv2prRJvg=",
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    "letna",
                    "SI",
                    "MB-UM-123",
                    "PayPal",
                    true
            );

            // https://stackoverflow.com/questions/48961551/how-to-make-lombok-gson-work-with-spring-aop-proxies
            /*System.out.println("se????");

            System.out.println("v");
            System.out.println(v);

            System.out.println("1");
            Gson gson = new Gson();
            System.out.println("2");
            String json = gson.toJson(v);
            System.out.println("3");
            System.out.println(json);
            System.out.println("4");*/

            Integer lastBillInternalCode = getLastBillInternalCode();
            Integer newBillInternalCode = lastBillInternalCode + 1;
            return nakupRepositoty.insert(
                    new Nakup(
                            newBillInternalCode,
                            v,
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

    public Boolean checkPurchase(String identifikator) {
        return mongoService.IsCheckPurchase(identifikator);
    }
}
