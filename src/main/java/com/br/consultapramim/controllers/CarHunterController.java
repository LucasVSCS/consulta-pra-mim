package com.br.consultapramim.controllers;

import com.br.consultapramim.domains.dtos.CarHunterDTO;
import com.br.consultapramim.domains.dtos.CarHunterInsertDTO;
import com.br.consultapramim.domains.dtos.CarHunterPaginationFilterDTO;
import com.br.consultapramim.domains.dtos.PaginationResultResponseDTO;
import com.br.consultapramim.repositories.CarHunterRepository;
import com.br.consultapramim.services.CarHunterService;
import com.br.consultapramim.utils.MessageResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Validated
@RequestMapping("/car-hunters")
public class CarHunterController {
    @Autowired
    private CarHunterService carHunterService;
    @Autowired
    private CarHunterRepository carHunterRepository;

    @GetMapping
    public ResponseEntity<PaginationResultResponseDTO<CarHunterDTO>> getCarHunter(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder,
            CarHunterPaginationFilterDTO paginationFilter
    ) {
        PaginationResultResponseDTO<CarHunterDTO> carHunterList = carHunterService.getAllCarHunters(pageNo, pageSize, sortBy, sortOrder, paginationFilter);
        return ResponseEntity.ok().body(carHunterList);
    }

    @GetMapping("/{external-id}")
    public ResponseEntity<CarHunterDTO> getCarHunterByExternalId(@PathVariable("external-id") UUID externalId) {
        CarHunterDTO carHunter = carHunterService.getCarHunterByExternalId(externalId);
        return ResponseEntity.ok().body(carHunter);
    }

    @PostMapping
    public ResponseEntity<CarHunterDTO> storeCarHunter(@Valid @RequestBody CarHunterInsertDTO carHunterDTO) {
        CarHunterDTO carHunter = carHunterService.storeCarHunter(carHunterDTO);
        return ResponseEntity.ok().body(carHunter);
    }

    @PutMapping("/{external-id}")
    public MessageResponse updateCarHunter(@PathVariable("external-id") UUID externalId, @RequestBody CarHunterInsertDTO carHunterDTO) {
        return carHunterService.updateCarHunter(externalId, carHunterDTO);
    }

    @DeleteMapping("/{external-id}")
    public MessageResponse deleteCarHunter(@PathVariable("external-id") UUID externalId) {
        return carHunterService.deleteCarHunter(externalId);
    }
}
