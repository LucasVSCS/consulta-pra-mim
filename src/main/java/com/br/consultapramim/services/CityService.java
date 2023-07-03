package com.br.consultapramim.services;

import com.br.consultapramim.domains.City;

import java.util.List;

public interface CityService {
    List<City> getCitiesByName(String cityName);
}
