package com.br.consultapramim.application.controllers;

import com.br.consultapramim.application.domains.City;
import com.br.consultapramim.application.domains.dtos.CityDTO;
import com.br.consultapramim.application.services.CityService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getCities() {
        List<City> cityList = cityService.getCities();
        return ResponseEntity.ok().body(cityList);
    }

    @GetMapping("/get-by-name")
    public ResponseEntity<List<City>> getCitiesByName(@RequestParam @NotNull String name) {
        List<City> cityList = cityService.getCitiesByName(name);
        return ResponseEntity.ok().body(cityList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> getCityById(@PathVariable("id") Long id) {
        CityDTO city = cityService.getCityById(id);
        return ResponseEntity.ok().body(city);
    }
}
