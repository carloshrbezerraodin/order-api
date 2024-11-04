package com.externoa.model;

import org.springframework.scheduling.config.Task;

import lombok.Data;

@Data
public class ResponseObject {
    Task data;
    Error error;
    String status;
}