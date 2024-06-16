package com.deiz0n.springsecurity.domain.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Error {

    private Instant instant;
    private String title;
    private HttpStatus status;
    private String details;
    private String uri;

}
