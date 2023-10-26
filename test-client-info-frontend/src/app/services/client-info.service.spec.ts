import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { ClientInfoService } from './client-info.service';
import { ClientRequest } from '../models/client-request.model';
import { ClientInfo } from '../models/client-info.model';

describe('ClientInfoService', () => {
  let service: ClientInfoService;
  let httpTestingController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ClientInfoService]
    });
    service = TestBed.inject(ClientInfoService);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpTestingController.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should send a POST request to the correct URL and return the client info', () => {
    const clientRequest: ClientRequest = {
      documentType: 'C',
      documentNumber: '23445322'
    };
    const expectedClientInfo: ClientInfo = {
      firstName: 'Carlos',
      secondName: 'Andres',
      firstSurname: 'Mendoza',
      secondSurname: 'Jaimes',
      phone: '3008445679',
      address: 'Cra. 8 #7 - 26, La Candelaria',
      cityResidence: 'Bogotá'
    };

    service.getClientInfo(clientRequest).subscribe((clientInfo) => {
      expect(clientInfo).toEqual(expectedClientInfo);
    });

    const req = httpTestingController.expectOne('http://localhost:8090/client_info/document');
    expect(req.request.method).toBe('POST');
    expect(req.request.body).toEqual(clientRequest);

    req.flush(expectedClientInfo);
  });
});
