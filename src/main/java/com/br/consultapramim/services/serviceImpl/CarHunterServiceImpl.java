package com.br.consultapramim.services.serviceImpl;

import com.br.consultapramim.domains.dtos.CarHunterDTO;
import com.br.consultapramim.repositories.CarHunterRepository;
import com.br.consultapramim.services.CarHunterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarHunterServiceImpl implements CarHunterService {
    @Autowired
    private CarHunterRepository carHunterRepository;

    @Override
    public List<CarHunterDTO> getCarHunters() {
        return carHunterRepository.findAll().stream().map(CarHunterDTO::new).toList();
    }
}
