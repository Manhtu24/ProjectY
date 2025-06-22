package com.MTlovec.SharedOf.exception.common;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomException extends RuntimeException {
    private int httpStatus;
    private String message;
    private Object data;

    public CustomException(String message) {
        super(message);
    }
}
