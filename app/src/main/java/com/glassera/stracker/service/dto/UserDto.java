package com.glassera.stracker.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {

    @JsonProperty
    private String username;
    @JsonProperty
    private String password;
    @JsonProperty
    private String token;
    @JsonProperty
    private int duration;
}
