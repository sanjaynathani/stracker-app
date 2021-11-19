package com.glassera.stracker.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InsuranceDto {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Member Id/Account #")
    private String accountNo;
    @JsonProperty("Website/Contact")
    private String contact;
    @JsonProperty("Notes")
    private String notes;
}
