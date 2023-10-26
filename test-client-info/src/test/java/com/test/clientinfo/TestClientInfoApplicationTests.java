package com.test.clientinfo;

import com.test.clientinfo.application.services.ClientInfoService;
import com.test.clientinfo.domain.dtos.ClientInfoRequest;
import com.test.clientinfo.domain.dtos.ClientInfoResponse;
import com.test.clientinfo.domain.enums.DocumentType;
import com.test.clientinfo.infrastructure.controllers.ClientInfoController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest
class TestClientInfoApplicationTests {
	@InjectMocks
	private ClientInfoController clientInfoController;

	@Mock
	private ClientInfoService clientInfoService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetClientInfoByDocumentNotFound() {
		ClientInfoRequest request = new ClientInfoRequest();
		request.setDocumentType(DocumentType.C);
		request.setDocumentNumber("123456");

		when(clientInfoService.getClientInfoByDocument(request)).thenReturn(null);

		ResponseEntity<ClientInfoResponse> responseEntity = clientInfoController.getClientInfoByDocument(request);

		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
	}
}
