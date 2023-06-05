import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-doacao',
  templateUrl: './doacao.component.html',
  styleUrls: ['./doacao.component.css']
})
export class DoacaoComponent {

  constructor(private router: Router) {
  }

  clearRouterLink() {
    this.router.navigateByUrl('/catalog', { replaceUrl: true });
  }
}
