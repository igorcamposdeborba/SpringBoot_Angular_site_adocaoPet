import { Component, ElementRef, HostListener, Renderer2 } from '@angular/core';

@Component({
  selector: 'app-adoption-process-banner',
  templateUrl: './adoption-process-banner.component.html',
  styleUrls: ['./adoption-process-banner.component.css']
})
export class AdoptionProcessBannerComponent {
  
  @HostListener('window:resize', ['$event']) // listener da DOM para alteração do tamanho da tela
  getImageSource(): string {
    window.innerWidth;
    if (window.innerWidth > 900) {
      return 'assets/processo-adocao.jpg';
      
    } else if (window.innerWidth > 500) {
      return 'assets/processo-adocao-tablet.jpg';
      
    } else {
      return 'assets/processo-adocao-mobile.jpg';
    }
  }
}
