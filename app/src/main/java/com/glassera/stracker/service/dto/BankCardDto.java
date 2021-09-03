package com.glassera.stracker.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BankCardDto {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Card #")
    private String cardNo;
    @JsonProperty("CVV")
    private String cvv;
    @JsonProperty("Expiry Date")
    private String expiryDate;
    @JsonProperty("Website/Contact")
    private String contact;
    @JsonProperty("Notes")
    private String notes;
}
