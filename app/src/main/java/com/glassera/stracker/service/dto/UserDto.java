package com.glassera.stracker.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {

    @JsonProperty("user_id")
    private String userId;
    @JsonProperty
    private String username;
    @JsonProperty
    private String password;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty
    private String email;
    @JsonProperty("mobile_no")
    private String mobileNo;
    @JsonProperty
    private String token;
    @JsonProperty
    private int duration;
    @JsonProperty
    private boolean logout;
}
