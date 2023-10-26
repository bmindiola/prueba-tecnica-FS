import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ClientRequest } from '../models/client-request.model';
import { ClientInfo } from '../models/client-info.model';

@Injectable({
  providedIn: 'root'
})
export class ClientInfoService {

  constructor(private http: HttpClient) { }

  getClientInfo(clientRequest: ClientRequest) {
    return this.http.post<ClientInfo>('http://localhost:8090/client_info/document', clientRequest)
  }
}
