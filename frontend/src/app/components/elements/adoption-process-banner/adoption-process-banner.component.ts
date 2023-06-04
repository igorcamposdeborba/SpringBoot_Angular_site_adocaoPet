import { Component } from '@angular/core';

@Component({
  selector: 'app-adoption-process-banner',
  templateUrl: './adoption-process-banner.component.html',
  styleUrls: ['./adoption-process-banner.component.css']
})
export class AdoptionProcessBannerComponent {

  scrollToTop() {
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }
}
