package com.glassera.stracker.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InvestmentDto {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Account #")
    private String accountNo;
    @JsonProperty("Website/Contact")
    private String contact;
    @JsonProperty("Notes")
    private String notes;
}
