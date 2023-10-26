package com.test.clientinfo.infrastructure.repositories;

import com.test.clientinfo.infrastructure.entities.ClientInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientInfoJpaRepository extends JpaRepository<ClientInfoEntity, Long> {
    Optional<ClientInfoEntity> findByDocumentTypeAndDocumentNumber(String documentType, String documentNumber);
}
