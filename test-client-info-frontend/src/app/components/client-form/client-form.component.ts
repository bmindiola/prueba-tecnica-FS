import { Component } from '@angular/core';

import { ClientRequest } from '../../models/client-request.model'
import { ClientInfoService } from 'src/app/services/client-info.service';
import { Router, ActivatedRoute } from '@angular/router';
import { ClientInfo } from 'src/app/models/client-info.model';

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: []
})
export class ClientFormComponent {
  documentType: string = '';
  documentNumber: string = '';
  documentNumberFormatted: string = '';
  isButtonDisabled: boolean = true;
  errorMessage = ''

  constructor(
    private clientInfoService: ClientInfoService,
    private router: Router
    ) {}

  updateButtonState() {
    this.isButtonDisabled = !(this.documentType && this.documentNumber.length >= 8 && this.documentNumber.length <= 11);
  }

  validateDocumentNumber(event: KeyboardEvent) {
    const input = event.key;
    if (!/^\d+$/.test(input) || this.documentNumber.length >= 11) {
      event.preventDefault();
    }
  }

  formattedNumber() {
    this.documentNumber = this.documentNumberFormatted.replace(/[^0-9]/g, '');
    this.documentNumberFormatted = this.addThousandSeparators(this.documentNumber)
  }

  addThousandSeparators(value: string): string {
    return (+value).toLocaleString();
  }

  searchClient() {
    const clientRequest: ClientRequest = {
      documentType: this.documentType,
      documentNumber: this.documentNumber
    }
    this.clientInfoService.getClientInfo(clientRequest).subscribe(
      (response) => {
        const clientInfo: ClientInfo = response
        this.router.navigate(['/resume'], {state: {data: clientInfo }});
      },
      (error) => {
        console.log(error)
        if (error.status == 404) {
          this.errorMessage = 'Error, usuario no encontrado.'
          return
        }
        if (error.status == 500) {
          this.errorMessage = 'Error de servidor. Intenta nuevamente mas tarde.'
          return
        }
        this.errorMessage = 'Error desconocido. Intenta nuevamente mas tarde.'
      }
    )
  }
}
