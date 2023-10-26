package com.test.clientinfo.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientInfo {
    private String documentType;
    private String documentNumber;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private String phone;
    private String address;
    private String cityResidence;
}
