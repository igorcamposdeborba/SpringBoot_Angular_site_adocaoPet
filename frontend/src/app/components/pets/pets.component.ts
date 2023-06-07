import { Component } from '@angular/core';
import { Ong, Pet } from 'src/app/models/pet';
import { PetService } from 'src/app/services/pet.service';
import { ActivatedRoute, Router } from '@angular/router';
import { MiniBannerComponent } from '../elements/mini-banner/mini-banner.component';

@Component({
  selector: 'app-pets',
  templateUrl: './pets.component.html',
  styleUrls: ['./pets.component.css']
})
export class PetsComponent {
  private id;

  ELEMENT_DATA_ONG: Ong = {
    id: 0,
    name: '',
    email: '',
    telephone: '',
    website: '',
    responsible: ''
  }
  
  ELEMENT_DATA_PET: Pet = {
    name: '',
    image: '',
    size: '',
    gender: '',
    health: [],
    age: 0,
    temperament: '',
    nameOng: ''
  }

  constructor(private service: PetService, private route: ActivatedRoute, private router: Router){
    MiniBannerComponent;
  }
  ngOnInit(): void { // ciclo de vida: ao iniciar o componente
    this.id = this.route.snapshot.paramMap.get('id'); // insere na url o id para a requisição
    this.findById(this.id);
    this.scrollToTop()
  }
  
  findById(id :number){ // View chama requisição do service.
    this.service.findById(id).subscribe(response => {
      this.ELEMENT_DATA_PET = response;
    }); 
  }

  clearRouterLink() {
    this.router.navigateByUrl('/catalog', { replaceUrl: true }); // altera o url ao invés de incrementar
  }
  scrollToTop() {
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }
}
