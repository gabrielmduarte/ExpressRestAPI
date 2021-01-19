package com.express.cadastro.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotFoundResponse {

    private LocalDateTime dateTime;
    private String message;

}
