package com.example.statisticservice.service;

import com.example.statisticservice.model.StatisticDTO;

import java.util.List;

public interface StatisticService {
    void addStatistic(StatisticDTO statisticDTO);
    List<StatisticDTO> getAllStatistics();
}
