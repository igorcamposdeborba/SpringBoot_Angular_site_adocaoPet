import { Component, OnInit } from '@angular/core';
import { CookiesComponent } from '../static-pages/cookies/cookies.component';
import {MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {
  private timer : any;

  constructor(private dialog: MatDialog){
  }
  
  ngOnInit(): void { // ciclo de vida: ao iniciar o componente
    this.timer = setTimeout(() => {
      const element = document.getElementById('cookies-notification');
      if (element) {
        element.remove();
      }
    }, 10000);
  }

  ngOnDestroy() { // ciclo de vida: para retirar da DOM o componente
    clearTimeout(this.timer);
  }

    
  openDialog() {
    this.dialog.open(CookiesComponent);
  }
}
