package com.example.statisticservice.controller;

import com.example.statisticservice.model.StatisticDTO;
import com.example.statisticservice.service.StatisticService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @PostMapping("/statistic")
    public StatisticDTO addStatistic(@RequestBody StatisticDTO statisticDTO) {

        log.info("Adding statistic: {}", statisticDTO);
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        statisticService.addStatistic(statisticDTO);
        return statisticDTO;
    }

    @GetMapping("/statistics")
    public List<StatisticDTO> getAll() {
        log.info("Getting all statistics");
        return statisticService.getAllStatistics();
    }



}
