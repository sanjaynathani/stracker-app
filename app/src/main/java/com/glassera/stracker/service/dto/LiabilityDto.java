package com.glassera.stracker.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LiabilityDto {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Account #")
    private String account;
    @JsonProperty("Website/Contact")
    private String contact;
    @JsonProperty("Notes")
    private String notes;
}
