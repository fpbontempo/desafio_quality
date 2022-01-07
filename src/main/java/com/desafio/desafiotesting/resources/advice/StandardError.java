package com.desafio.desafiotesting.resources.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class StandardError implements Serializable {
    private static final long serialVersionUID = 1740304141568378664L;

    private Long timestamp;
    private Integer status;
    private String error;
    private String path;
    private String message;
}

