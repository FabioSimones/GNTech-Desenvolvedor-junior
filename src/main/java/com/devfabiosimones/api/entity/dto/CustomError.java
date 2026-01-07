package com.devfabiosimones.api.entity.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class CustomError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
}
