package com.br.consultapramim.controllers;

import com.br.consultapramim.domains.dtos.CarHunterDTO;
import com.br.consultapramim.services.CarHunterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("/car-hunters")
public class CarHunterController {
    @Autowired
    private CarHunterService carHunterService;

    @GetMapping
    public ResponseEntity<List<CarHunterDTO>> getCarHunter() {
        List<CarHunterDTO> carHunterList = carHunterService.getCarHunters();
        return ResponseEntity.ok().body(carHunterList);
    }
}
