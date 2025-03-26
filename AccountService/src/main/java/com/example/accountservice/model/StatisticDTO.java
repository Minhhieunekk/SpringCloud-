package com.example.accountservice.model;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class StatisticDTO {
    private int id;
    @NonNull
    private String message;
    @NonNull
    private Date createdDate;
}
