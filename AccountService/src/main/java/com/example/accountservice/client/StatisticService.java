package com.example.accountservice.client;

import com.example.accountservice.model.StatisticDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "statistic-service", url = "http://localhost:9082", fallback = StatisticServiceImpl.class)
public interface StatisticService {

    @PostMapping("/statistic")
    void addStatistic(@RequestBody StatisticDTO statisticDTO);


}
