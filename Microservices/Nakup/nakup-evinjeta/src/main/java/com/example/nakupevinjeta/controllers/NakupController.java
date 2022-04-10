package com.example.nakupevinjeta.controllers;

import java.util.List;

import com.example.nakupevinjeta.models.Nakup;
import com.example.nakupevinjeta.services.NakupService;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nakup")
@AllArgsConstructor
public class NakupController {

    private final NakupService nakupService;

    @GetMapping("/single")
    public List<Nakup> fetchNakupList(
            @RequestParam(
                    value = "name",
                    defaultValue = "World"
            )String name){
        return nakupService.getNakupList();
    }

    @GetMapping("/all")
    public List<Nakup> fetchAllNakupList() {
        return nakupService.getAllNakupList();
    }

    @GetMapping("/lastBillInternalCode")
    public Integer fetchLastBillInternalCode() {
        return nakupService.getLastBillInternalCode();
    }

    @GetMapping("/check")
    public Boolean checkPurchse(@RequestParam (name="identifikator") String identifikator) {
        return nakupService.checkPurchase(identifikator);
    }

    @PostMapping("/new")
    public Nakup newNakup(){ //@RequestBody Nakup nakup

        System.out.println("se naredi");
        return nakupService.newNakup();
    }

    @DeleteMapping("/remove")
    public boolean removeNakup(){
        return nakupService.removeNakup();
    }

}