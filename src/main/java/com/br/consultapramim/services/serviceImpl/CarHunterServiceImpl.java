package com.br.consultapramim.services.serviceImpl;

import com.br.consultapramim.domains.CarHunter;
import com.br.consultapramim.domains.dtos.CarHunterDTO;
import com.br.consultapramim.domains.dtos.PaginationResultResponseDTO;
import com.br.consultapramim.repositories.CarHunterRepository;
import com.br.consultapramim.services.CarHunterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CarHunterServiceImpl implements CarHunterService {
    @Autowired
    private CarHunterRepository carHunterRepository;

    @Override
    public PaginationResultResponseDTO<CarHunterDTO> getAllCarHunters(Integer pageNo, Integer pageSize, String sortBy, String nameFilter) {
        Specification<CarHunter> spec = Specification.where(null);

        if (nameFilter != null) {
            spec = spec.and((root, query, builder) ->
                    builder.like(builder.lower(root.get("name")), "%" + nameFilter.toLowerCase() + "%"));
        }

        PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, sortBy));

        Page<CarHunter> pagedResult = carHunterRepository.findAll(spec, paging);

        long totalElements = pagedResult.getTotalElements();
        int totalPages = pagedResult.getTotalPages();

        return new PaginationResultResponseDTO<>(pagedResult.map(CarHunterDTO::new).getContent(), pageNo, pageSize, totalPages, totalElements);
    }
}
