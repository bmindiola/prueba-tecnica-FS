package com.test.clientinfo.infrastructure.adapters;

import com.test.clientinfo.application.mappers.ClientInfoMapper;
import com.test.clientinfo.domain.models.ClientInfo;
import com.test.clientinfo.domain.ports.ClientInfoRepository;
import com.test.clientinfo.infrastructure.entities.ClientInfoEntity;
import com.test.clientinfo.infrastructure.repositories.ClientInfoJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClientInfoRepositoryImpl implements ClientInfoRepository {
    private final ClientInfoJpaRepository clientInfoJpaRepository;
    private final ClientInfoMapper clientInfoMapper;

    public ClientInfoRepositoryImpl(ClientInfoJpaRepository clientInfoJpaRepository, ClientInfoMapper clientInfoMapper) {
        this.clientInfoJpaRepository = clientInfoJpaRepository;
        this.clientInfoMapper = clientInfoMapper;
    }

    @Override
    public ClientInfo findClientInfoByDocument(String documentType, String documentNumber) {
        Optional<ClientInfoEntity> clientInfoEntityOptional = clientInfoJpaRepository.findByDocumentTypeAndDocumentNumber(
                documentType, documentNumber);
        if (clientInfoEntityOptional.isEmpty()) return null;
        ClientInfoEntity clientInfoEntity = clientInfoEntityOptional.get();
        return clientInfoMapper.toModel(clientInfoEntity);
    }
}
