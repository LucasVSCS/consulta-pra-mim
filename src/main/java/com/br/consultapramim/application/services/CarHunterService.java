package com.br.consultapramim.application.services;

import com.br.consultapramim.application.domains.dtos.CarHunterDTO;
import com.br.consultapramim.application.domains.dtos.CarHunterInsertDTO;
import com.br.consultapramim.application.domains.dtos.CarHunterPaginationFilterDTO;
import com.br.consultapramim.application.domains.dtos.PaginationResultResponseDTO;
import com.br.consultapramim.application.utils.MessageResponse;

import java.util.UUID;

public interface CarHunterService {
    PaginationResultResponseDTO<CarHunterDTO> getAllCarHunters(Integer pageNo, Integer pageSize, String sortBy, String sortOrder, CarHunterPaginationFilterDTO paginationFilter);
    CarHunterDTO getCarHunterByExternalId(UUID externalId);
    CarHunterDTO storeCarHunter(CarHunterInsertDTO carHunterDTO);
    MessageResponse updateCarHunter(UUID externalId, CarHunterInsertDTO carHunterDTO);
    MessageResponse deleteCarHunter(UUID externalId);
}
