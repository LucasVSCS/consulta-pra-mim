package com.br.consultapramim.services;

import com.br.consultapramim.domains.dtos.CarHunterDTO;
import com.br.consultapramim.domains.dtos.CarHunterInsertDTO;
import com.br.consultapramim.domains.dtos.CarHunterPaginationFilterDTO;
import com.br.consultapramim.domains.dtos.PaginationResultResponseDTO;
import com.br.consultapramim.utils.MessageResponse;

import java.util.UUID;

public interface CarHunterService {
    PaginationResultResponseDTO<CarHunterDTO> getAllCarHunters(Integer pageNo, Integer pageSize, String sortBy, String sortOrder, CarHunterPaginationFilterDTO paginationFilter);
    CarHunterDTO getCarHunterByExternalId(UUID externalId);
    CarHunterDTO storeCarHunter(CarHunterInsertDTO carHunterDTO);
    MessageResponse updateCarHunter(UUID externalId, CarHunterInsertDTO carHunterDTO);
    MessageResponse deleteCarHunter(UUID externalId);
}
