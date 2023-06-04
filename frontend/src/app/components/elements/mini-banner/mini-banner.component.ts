import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-mini-banner',
  templateUrl: './mini-banner.component.html',
  styleUrls: ['./mini-banner.component.css']
})
export class MiniBannerComponent {
  title : string;
  description : string;

  constructor(){
  }
  
  ngOnInit(): void { // ciclo de vida: ao iniciar o componente

  }

}
