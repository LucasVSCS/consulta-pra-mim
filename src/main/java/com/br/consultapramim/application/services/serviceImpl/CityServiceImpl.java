package com.br.consultapramim.application.services.serviceImpl;

import com.br.consultapramim.application.domains.City;
import com.br.consultapramim.application.domains.dtos.CityDTO;
import com.br.consultapramim.application.repositories.CityRepository;
import com.br.consultapramim.application.services.CityService;
import com.br.consultapramim.application.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getCities() {
        return cityRepository.findAll();
    }

    @Override
    public List<City> getCitiesByName(String cityName) {
        return cityRepository.findByNameLikeIgnoreCase(cityName);
    }

    @Override
    public CityDTO getCityById(Long id) {
        City city = cityRepository.findById(id).orElse(null);
        if (Objects.isNull(city)) throw new ObjectNotFoundException("CarHunter not found");

        return new CityDTO(city);
    }
}
