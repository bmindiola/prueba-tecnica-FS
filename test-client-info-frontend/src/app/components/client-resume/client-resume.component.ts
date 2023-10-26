import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { ClientInfo } from 'src/app/models/client-info.model';

@Component({
  selector: 'app-client-resume',
  templateUrl: './client-resume.component.html',
  styleUrls: []
})
export class ClientResumeComponent {
  clientInfo: ClientInfo = {
    firstName: '',
    secondName: '',
    firstSurname: '',
    secondSurname: '',
    phone: '',
    address: '',
    cityResidence: ''
  };

  clientInfoArray: Array<{key: string, value: string}> = []

  constructor(private router: Router) {
    const navigation = this.router.getCurrentNavigation();
    if (navigation?.extras.state) {
      this.clientInfo = navigation.extras.state['data'];
      this.clientInfoArray = Object.keys(this.clientInfo).map(key => ({ key, value: this.clientInfo[key as keyof ClientInfo] }));
    }
  }

  back() {
    this.router.navigate(['/']);
  }
}
