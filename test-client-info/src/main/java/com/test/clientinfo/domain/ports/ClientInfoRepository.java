package com.test.clientinfo.domain.ports;

import com.test.clientinfo.domain.models.ClientInfo;

public interface ClientInfoRepository {
    ClientInfo findClientInfoByDocument(String documentType, String documentNumber);
}
