import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-mini-banner',
  templateUrl: './mini-banner.component.html',
  styleUrls: ['./mini-banner.component.css']
})
export class MiniBannerComponent {
  @Input() title : string;
  @Input() description : string;
  @Input() backgroundImage : string;
  @Input() url : string;

  constructor(){
  }
  
  ngOnInit(): void { // ciclo de vida: ao iniciar o componente

  }

  scrollToTop() {
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }
}
