import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ong',
  templateUrl: './ong.component.html',
  styleUrls: ['./ong.component.css']
})
export class OngComponent {
  constructor(private router: Router) {
  }

  clearRouterLink() {
    this.router.navigateByUrl('/catalog', { replaceUrl: true });
  }
}
