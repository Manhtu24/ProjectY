package com.MTlovec.SharedOf.dto.common;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BaseResponse <T>{
    @JsonProperty("success")
    private final int code;

    @JsonProperty("data")
    private T data;

    @JsonProperty("message")
    private final String message;



}
