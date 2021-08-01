package com.byamada.call.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StandardError {

    private Long timeStamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
