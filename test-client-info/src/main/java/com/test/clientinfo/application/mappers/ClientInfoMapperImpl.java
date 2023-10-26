package com.test.clientinfo.application.mappers;

import com.test.clientinfo.domain.dtos.ClientInfoResponse;
import com.test.clientinfo.domain.models.ClientInfo;
import com.test.clientinfo.infrastructure.entities.ClientInfoEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientInfoMapperImpl implements ClientInfoMapper{
    @Override
    public ClientInfo toModel(ClientInfoEntity clientInfoEntity) {
        return ClientInfo.builder()
                .documentType(clientInfoEntity.getDocumentType())
                .documentNumber(clientInfoEntity.getDocumentNumber())
                .firstName(clientInfoEntity.getFirstName())
                .secondName(clientInfoEntity.getSecondName())
                .firstSurname(clientInfoEntity.getFirstSurname())
                .secondSurname(clientInfoEntity.getSecondSurname())
                .phone(clientInfoEntity.getPhone())
                .address(clientInfoEntity.getAddress())
                .cityResidence(clientInfoEntity.getCityResidence())
                .build();
    }

    @Override
    public ClientInfoResponse toResponse(ClientInfo clientInfo) {
        return ClientInfoResponse.builder()
                .firstName(clientInfo.getFirstName())
                .secondName(clientInfo.getSecondName())
                .firstSurname(clientInfo.getFirstSurname())
                .secondSurname(clientInfo.getSecondSurname())
                .phone(clientInfo.getPhone())
                .address(clientInfo.getAddress())
                .cityResidence(clientInfo.getCityResidence())
                .build();
    }
}
