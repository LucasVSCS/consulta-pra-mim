package com.br.consultapramim.services.serviceImpl;

import com.br.consultapramim.domains.CarHunter;
import com.br.consultapramim.domains.City;
import com.br.consultapramim.domains.dtos.CarHunterDTO;
import com.br.consultapramim.domains.dtos.CarHunterInsertDTO;
import com.br.consultapramim.domains.dtos.CarHunterPaginationFilterDTO;
import com.br.consultapramim.domains.dtos.PaginationResultResponseDTO;
import com.br.consultapramim.domains.specifications.CarHunterSpecification;
import com.br.consultapramim.repositories.CarHunterRepository;
import com.br.consultapramim.repositories.CityRepository;
import com.br.consultapramim.services.CarHunterService;
import com.br.consultapramim.services.exceptions.ObjectNotFoundException;
import com.br.consultapramim.utils.MessageResponse;
import com.br.consultapramim.utils.MessageUtil;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class CarHunterServiceImpl implements CarHunterService {
    @Autowired
    private CarHunterRepository carHunterRepository;
    @Autowired
    private CityRepository cityRepository;

    @Override
    public PaginationResultResponseDTO<CarHunterDTO> getAllCarHunters(Integer pageNo, Integer pageSize, String sortBy, String sortOrder, CarHunterPaginationFilterDTO paginationFilter) {
        Specification<CarHunter> carHunterSpecification = carHunterPaginationFilter(paginationFilter);

        PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(sortOrder.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, sortBy));

        Page<CarHunter> pagedResult = carHunterRepository.findAll(carHunterSpecification, paging);

        long totalElements = pagedResult.getTotalElements();
        int totalPages = pagedResult.getTotalPages();

        return new PaginationResultResponseDTO<>(pagedResult.map(CarHunterDTO::new).getContent(), pageNo, pageSize, totalPages, totalElements);
    }

    @Override
    public CarHunterDTO getCarHunterByExternalId(UUID externalId) {
        CarHunter carHunter = carHunterRepository.findByExternalId(externalId);

        if (Objects.isNull(carHunter)) throw new ObjectNotFoundException("CarHunter not found");

        return new CarHunterDTO(carHunter);
    }

    @Override
    public CarHunterDTO storeCarHunter(CarHunterInsertDTO carHunterInsertDTO) {
        CarHunter carHunter = new CarHunter(carHunterInsertDTO);
        City city = cityRepository.findById(carHunterInsertDTO.getCityId()).orElseThrow(() -> new ObjectNotFoundException("City not found"));
        carHunter.setCity(city);

        return new CarHunterDTO(carHunterRepository.save(carHunter));
    }

    @Transactional
    @Override
    public MessageResponse updateCarHunter(UUID externalId, CarHunterInsertDTO carHunterInsertDTO) {
        CarHunter carHunter = carHunterRepository.findByExternalId(externalId);

        if (Objects.isNull(carHunter)) throw new ObjectNotFoundException("CarHunter not found");

        carHunter.setName(carHunterInsertDTO.getName());
        carHunter.setTradingName(carHunterInsertDTO.getTradingName());
        carHunter.setEmail(carHunterInsertDTO.getEmail());

        City city = cityRepository.findById(carHunterInsertDTO.getCityId()).orElseThrow(() -> new ObjectNotFoundException("City not found"));
        carHunter.setCity(city);
        carHunterRepository.save(carHunter);

        return new MessageResponse(MessageUtil.MSE_S01.getMsgAbbreviation(), MessageUtil.MSE_S01.getMsgDescription());
    }

    private Specification<CarHunter> carHunterPaginationFilter(CarHunterPaginationFilterDTO paginationFilter) {
        Specification<CarHunter> spec = Specification.where(null);

        if (Strings.isNotEmpty(paginationFilter.getName())) {
            spec = spec.and(CarHunterSpecification.withName(paginationFilter.getName()));
        }

        if (Strings.isNotEmpty(paginationFilter.getTradingName())) {
            spec = spec.and(CarHunterSpecification.withTradingName(paginationFilter.getTradingName()));
        }

        if (Objects.nonNull(paginationFilter.getCityId())) {
            spec = spec.and(CarHunterSpecification.withCity(paginationFilter.getCityId()));
        }

        return spec;
    }

}
