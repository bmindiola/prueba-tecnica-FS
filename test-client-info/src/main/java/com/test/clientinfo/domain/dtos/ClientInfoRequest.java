package com.test.clientinfo.domain.dtos;

import com.test.clientinfo.domain.enums.DocumentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientInfoRequest {
    @NotNull(message = "is required")
    private DocumentType documentType;
    @NotBlank(message = "is required")
    private String documentNumber;
}
