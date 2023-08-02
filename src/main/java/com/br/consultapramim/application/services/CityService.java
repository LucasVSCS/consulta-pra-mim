package com.br.consultapramim.application.services;

import com.br.consultapramim.application.domains.City;
import com.br.consultapramim.application.domains.dtos.CityDTO;

import java.util.List;

public interface CityService {
    List<City> getCities();
    List<City> getCitiesByName(String cityName);
    CityDTO getCityById(Long id);
}
