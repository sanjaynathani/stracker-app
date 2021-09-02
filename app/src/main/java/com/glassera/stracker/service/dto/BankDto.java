package com.glassera.stracker.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BankDto {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Account #")
    private String accountNo;
    @JsonProperty("Routing #")
    private String routingNo;
    @JsonProperty("Nominee")
    private String nominee;
    @JsonProperty("Notes")
    private String notes;

}
