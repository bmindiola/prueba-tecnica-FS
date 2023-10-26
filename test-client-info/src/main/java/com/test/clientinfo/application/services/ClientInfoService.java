package com.test.clientinfo.application.services;

import com.test.clientinfo.domain.dtos.ClientInfoRequest;
import com.test.clientinfo.domain.dtos.ClientInfoResponse;

public interface ClientInfoService {
    ClientInfoResponse getClientInfoByDocument(ClientInfoRequest clientInfoRequest);
}
