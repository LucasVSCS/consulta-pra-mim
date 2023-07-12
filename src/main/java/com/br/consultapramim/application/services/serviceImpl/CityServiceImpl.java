package com.br.consultapramim.application.services.serviceImpl;

import com.br.consultapramim.application.domains.City;
import com.br.consultapramim.application.repositories.CityRepository;
import com.br.consultapramim.application.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}