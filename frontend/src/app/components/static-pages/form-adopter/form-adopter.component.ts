import { DialogRef } from '@angular/cdk/dialog';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-form-adopter',
  templateUrl: './form-adopter.component.html',
  styleUrls: ['./form-adopter.component.css']
})

export class FormAdopterComponent {
  lastNumber;
  name;
  email;
  telephone;

  constructor(public dialog: MatDialog, private http: HttpClient, private route: ActivatedRoute, private forms : FormsModule,
              private dialogbox : DialogRef, private notification : MatSnackBar ){}
  ngOnInit() {
    this.route.url.subscribe(urlSegments => {
      const lastSegment = urlSegments[urlSegments.length - 1];
      // Passar o valor do último segmento para uma propriedade do componente
      this.lastNumber = lastSegment.path;
    });
  }

  openDialog() {
    this.dialog.open(FormAdopterComponent);
  }

  submitForm(formData: any) {

    const url = `http://localhost:8080/adotante/${this.getLastNumberFromURL()}`;
    const adopter = {
      name: this.name,
      email: this.email,
      telephone: this.telephone
    };

    this.http.post(url, adopter).subscribe(
      response => {
        this.dialogbox.close(response);
        this.notification.open("Enviado", "", { duration: 1000 });
        // location.reload();
      }, error => {
        this.dialogbox.close(error);
        this.notification.open(JSON.stringify(error.error.message), "", { duration: 8000 , panelClass: ['mat-toolbar', 'mat-warn'] });
      }
    );
  }
  
  getLastNumberFromURL() {
    const currentURL = window.location.href;
    const parts = currentURL.split('/');
    const lastPart = parts[parts.length - 1];
    return parseInt(lastPart, 10);
  }

  verifyRequiredFields(){
    if (this.name && this.telephone && this.email) {
      return true;
    } else {
      return false;
    }
  }
}
