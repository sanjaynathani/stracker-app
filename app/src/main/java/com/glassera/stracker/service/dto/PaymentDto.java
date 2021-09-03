package com.glassera.stracker.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PaymentDto {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Frequency")
    private String frequency;
    @JsonProperty("Website/Contact")
    private String contact;
    @JsonProperty("Notes")
    private String notes;
}
