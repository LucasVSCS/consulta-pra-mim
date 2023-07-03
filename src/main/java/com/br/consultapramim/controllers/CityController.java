package com.br.consultapramim.controllers;

import com.br.consultapramim.domains.City;
import com.br.consultapramim.services.CityService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/get-by-name")
    public ResponseEntity<List<City>> getCitiesByName(@RequestParam @NotNull String name) {
        List<City> cityList = cityService.getCitiesByName(name);
        return ResponseEntity.ok().body(cityList);
    }
}
