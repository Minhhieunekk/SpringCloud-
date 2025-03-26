package com.example.statisticservice.repository;

import com.example.statisticservice.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticRepository extends JpaRepository<Statistic, Integer> {

}
