package com.br.consultapramim.controllers;

import com.br.consultapramim.domains.dtos.CarHunterDTO;
import com.br.consultapramim.domains.dtos.CarHunterPaginationFilterDTO;
import com.br.consultapramim.domains.dtos.PaginationResultResponseDTO;
import com.br.consultapramim.services.CarHunterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/car-hunters")
public class CarHunterController {
    @Autowired
    private CarHunterService carHunterService;

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
}
