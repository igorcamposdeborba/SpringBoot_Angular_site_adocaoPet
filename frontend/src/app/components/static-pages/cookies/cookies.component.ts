import { Component } from '@angular/core';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';

@Component({
  selector: 'app-cookies',
  templateUrl: './cookies.component.html',
  styleUrls: ['./cookies.component.css']
})
export class CookiesComponent {

  constructor(public dialog: MatDialog){}

  openDialog() {
    this.dialog.open(CookiesComponent);
  }
}
