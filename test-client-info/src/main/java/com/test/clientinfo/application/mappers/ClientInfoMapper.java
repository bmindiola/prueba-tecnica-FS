package com.test.clientinfo.application.mappers;

import com.test.clientinfo.domain.dtos.ClientInfoResponse;
import com.test.clientinfo.domain.models.ClientInfo;
import com.test.clientinfo.infrastructure.entities.ClientInfoEntity;

public interface ClientInfoMapper {
    ClientInfo toModel(ClientInfoEntity clientInfoEntity);
    ClientInfoResponse toResponse(ClientInfo clientInfo);
}
