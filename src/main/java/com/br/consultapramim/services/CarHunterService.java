package com.br.consultapramim.services;

import com.br.consultapramim.domains.dtos.CarHunterDTO;
import com.br.consultapramim.domains.dtos.CarHunterPaginationFilterDTO;
import com.br.consultapramim.domains.dtos.PaginationResultResponseDTO;

public interface CarHunterService {
    PaginationResultResponseDTO<CarHunterDTO> getAllCarHunters(Integer pageNo, Integer pageSize, String sortBy, String sortOrder, CarHunterPaginationFilterDTO paginationFilter);
}
