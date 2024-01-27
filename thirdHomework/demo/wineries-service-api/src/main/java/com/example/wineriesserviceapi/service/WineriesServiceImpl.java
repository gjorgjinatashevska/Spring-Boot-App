package com.example.wineriesserviceapi.service;

import com.example.wineriesserviceapi.model.InvalidArgumentsException;
import com.example.wineriesserviceapi.model.Wineries;
import com.example.wineriesserviceapi.repository.WineriesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineriesServiceImpl implements WineriesService {
    @Autowired
    private final WineriesRepository wineriesRepository;

    public WineriesServiceImpl(WineriesRepository wineriesRepository) {
        this.wineriesRepository = wineriesRepository;
    }

    @Override
    public Wineries findById(Long ID) {
        return wineriesRepository.findById(ID).orElseThrow(InvalidArgumentsException::new);
    }

    @Transactional
    public void saveWineriesData(List<Wineries> wineries) {
        wineriesRepository.saveAll(wineries);
    }

}