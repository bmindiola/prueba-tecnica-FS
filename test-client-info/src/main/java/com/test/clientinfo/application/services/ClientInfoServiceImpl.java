package com.test.clientinfo.application.services;

import com.test.clientinfo.application.mappers.ClientInfoMapper;
import com.test.clientinfo.domain.dtos.ClientInfoRequest;
import com.test.clientinfo.domain.dtos.ClientInfoResponse;
import com.test.clientinfo.domain.models.ClientInfo;
import com.test.clientinfo.domain.ports.ClientInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientInfoServiceImpl implements ClientInfoService{
    private final ClientInfoRepository clientInfoRepository;
    private final ClientInfoMapper clientInfoMapper;

    public ClientInfoServiceImpl(ClientInfoRepository clientInfoRepository, ClientInfoMapper clientInfoMapper) {
        this.clientInfoRepository = clientInfoRepository;
        this.clientInfoMapper = clientInfoMapper;
    }

    @Override
    public ClientInfoResponse getClientInfoByDocument(ClientInfoRequest clientInfoRequest) {
        ClientInfo clientInfo = clientInfoRepository.findClientInfoByDocument(
                clientInfoRequest.getDocumentType().toString(), clientInfoRequest.getDocumentNumber());
        if (clientInfo == null) return null;
        return clientInfoMapper.toResponse(clientInfo);
    }
}
