package com.example.accountservice.client;

import com.example.accountservice.model.StatisticDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StatisticServiceImpl implements StatisticService{

    @Override
    public void addStatistic(StatisticDTO statisticDTO) {
            log.error("Statistic service is slow");
    }
}
