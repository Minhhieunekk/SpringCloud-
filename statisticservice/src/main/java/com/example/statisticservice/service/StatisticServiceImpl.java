package com.example.statisticservice.service;

import com.example.statisticservice.model.Statistic;
import com.example.statisticservice.model.StatisticDTO;
import com.example.statisticservice.repository.StatisticRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void addStatistic(StatisticDTO statisticDTO) {
        Statistic statistic=modelMapper.map(statisticDTO, Statistic.class);
        statisticRepository.save(statistic);
    }

    @Override
    public List<StatisticDTO> getAllStatistics() {
        List<StatisticDTO> statisticDTOS=new ArrayList<>();
        statisticRepository.findAll().forEach(statistic -> {
            StatisticDTO statisticDTO=modelMapper.map(statistic, StatisticDTO.class);
            statisticDTOS.add(statisticDTO);
        });
        return statisticDTOS;
    }
}
