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

    private final NakupService vinjetaService;

    @GetMapping("/single")
    public List<Nakup> fetchNakupList(
            @RequestParam(
                    value = "name",
                    defaultValue = "World"
            )String name){
        return vinjetaService.getNakupList();
    }

    @GetMapping("/all")
    public List<Nakup> fetchAllNakupList() {
        return vinjetaService.getAllNakupList();
    }

    @GetMapping("/lastBillInternalCode")
    public Integer fetchLastBillInternalCode() {
        return vinjetaService.getLastBillInternalCode();
    }

    @PostMapping("/new")
    public Nakup newNakup(@RequestBody Nakup nakup){
        return vinjetaService.newNakup(nakup.getContent());
    }

    @DeleteMapping("/remove")
    public boolean removeNakup(){
        return vinjetaService.removeNakup();
    }

}