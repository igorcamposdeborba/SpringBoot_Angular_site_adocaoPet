import { Component } from '@angular/core';
import { MiniBannerComponent } from '../elements/mini-banner/mini-banner.component';
import { AdoptionProcessBannerComponent } from '../elements/adoption-process-banner/adoption-process-banner.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  constructor(){
  }
  
  ngOnInit(): void { // ciclo de vida: ao iniciar o componente
    MiniBannerComponent;
    AdoptionProcessBannerComponent;
  }
  
}