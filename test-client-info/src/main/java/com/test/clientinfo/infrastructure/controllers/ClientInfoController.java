package com.test.clientinfo.infrastructure.controllers;

import com.test.clientinfo.application.services.ClientInfoService;
import com.test.clientinfo.domain.dtos.ClientInfoRequest;
import com.test.clientinfo.domain.dtos.ClientInfoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("client_info"))
@Validated
public class ClientInfoController {
    private final ClientInfoService clientInfoService;

    public ClientInfoController(ClientInfoService clientInfoService) {
        this.clientInfoService = clientInfoService;
    }

    @PostMapping("document")
    public ResponseEntity<ClientInfoResponse> getClientInfoByDocument(@Valid @RequestBody ClientInfoRequest clientInfoRequest) {
        ClientInfoResponse clientInfoResponse = clientInfoService.getClientInfoByDocument(clientInfoRequest);
        return clientInfoResponse != null
            ? new ResponseEntity<>(clientInfoResponse, HttpStatus.OK)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
